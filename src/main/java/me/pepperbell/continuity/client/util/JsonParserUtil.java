package me.pepperbell.continuity.client.util;

import com.google.gson.*;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class JsonParserUtil {
    public static JsonElement parseString(String json) throws JsonSyntaxException {
        return parseReader(new StringReader(json));
    }

    public static JsonElement parseReader(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement element = parseReader(jsonReader);
            if (!element.isJsonNull() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            } else {
                return element;
            }
        } catch (MalformedJsonException var3) {
            throw new JsonSyntaxException(var3);
        } catch (IOException var4) {
            throw new JsonIOException(var4);
        } catch (NumberFormatException var5) {
            throw new JsonSyntaxException(var5);
        }
    }

    public static JsonElement parseReader(JsonReader reader) throws JsonIOException, JsonSyntaxException {
        boolean lenient = reader.isLenient();
        reader.setLenient(true);

        JsonElement var2;
        try {
            var2 = Streams.parse(reader);
        } catch (StackOverflowError var7) {
            throw new JsonParseException("Failed parsing JSON source: " + reader + " to Json", var7);
        } catch (OutOfMemoryError var8) {
            throw new JsonParseException("Failed parsing JSON source: " + reader + " to Json", var8);
        } finally {
            reader.setLenient(lenient);
        }

        return var2;
    }
}
