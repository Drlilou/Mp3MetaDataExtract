import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class FilesPrinter {
        public Optional<MusicFileData> searchAndPrintFileDetails(String fileName) throws IOException {
        Optional<String> keyFile = Files.walk(Paths.get("C:\\Users\\sarat\\Music"))
                .map(path -> path.toString())
                .filter(file -> file.contains(".mp3"))
                .filter(file -> file.contains(fileName))
                .findFirst();

        if (keyFile.isPresent()) {
            return Optional.of(new ExtractMp3().printMetaData(keyFile.get()));
        } else {
            return Optional.empty();
        }
    }

}