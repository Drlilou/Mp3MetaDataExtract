import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;
public class ExtractMp3  {
    public static void main(String[] args) {
        ExtractMp3 demo = new ExtractMp3();
    }

    public MusicFileData printMetaData(String fileAddress) {
        try {
            InputStream input = new FileInputStream(new File(fileAddress));
            ContentHandler handler = new DefaultHandler();
            Metadata meta = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx  = new ParseContext();
            parser.parse(input , handler , meta , parseCtx);
            input.close();

            return new MusicFileData(
                    meta.get("title"),
                    meta.get("xmpDM:artist"),
                    meta.get("xmpDM:composer"),
                    meta.get("xmpDM:genre"),
                    meta.get("xmpDM:album")
            );
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch(TikaException e)
        {
            e.printStackTrace();
        }

        return null;
    }

}