package utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by w6c on 11/08/2014.
 */

public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonparser,
                            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

        System.out.println("%%%% CustomJsonDateDeserializer - deserialize %%%%%%");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateAux = jsonparser.getText();

        //Convert ISO 8601(padrao JSON) to DateTime
        Calendar calendar = javax.xml.bind.DatatypeConverter.parseDateTime(dateAux);
        //estudanteRequest.dataNascimento = calendar.getTime();

        System.out.println("%%%% dateAux: " + dateAux);

        try {
            System.out.println("%%%% format.parse(dateAux: " + format.parse(dateAux));
            return format.parse(calendar.getTime().toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        //System.out.println("%%%% calendar.getTime: " + calendar.getTime().toString());
        //return calendar.getTime();

    }
}
