package Config;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.time.*;

public class LocalDateTimeConverter implements Converter {
    @Override
    public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
        LocalDateTime data = (LocalDateTime) object;
        ZonedDateTime dataComZona = data.atZone(ZoneOffset.systemDefault());
        Long milisSegundo = dataComZona.toInstant().toEpochMilli();

        writer.startNode("time");
        writer.setValue(String.valueOf(milisSegundo));
        writer.endNode();

        writer.startNode("timeZone");
        writer.setValue(dataComZona.getZone().toString());
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        reader.moveDown();
        String millisSegundos = reader.getValue();
        reader.moveUp();

        reader.moveDown();
        String timeZone = reader.getValue();
        reader.moveUp();

        Long tempoEmMillis = Long.parseLong(millisSegundos);
        Instant tempo = Instant.ofEpochMilli(tempoEmMillis);
        ZoneId zone = ZoneId.of(timeZone);
        ZonedDateTime dataZona = ZonedDateTime.ofInstant(tempo, zone);
        LocalDateTime data = dataZona.toLocalDateTime();

        return data;
    }

    @Override
    public boolean canConvert(Class type) {
        return type.isAssignableFrom(LocalDateTime.class);
    }
}