/**
 * Created by jiangyy on 2017/9/8.
 */
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class index {
        public static void main(String[] args) {
            try {
                // read file content from file
                FileReader reader = new FileReader("D://work//translate//split_words//ja_cn//zimufinal_ja.txt");
                BufferedReader br = new BufferedReader(reader);

                // write string to file
                FileWriter writer = new FileWriter("D://translate//split_words//output//zimufinal_ja_output.txt");
                BufferedWriter bw = new BufferedWriter(writer);

                String str = null;
                int i = 0;
                Tokenizer tokenizer = new Tokenizer();
                List<Token> tokens = null;
                StringBuffer str_sp = null;
                while((str = br.readLine()) != null) {
                    i=i+1;
                    tokens = tokenizer.tokenize(str);
                    str_sp = new StringBuffer("");
                    for (Token token : tokens) {
                        str_sp.append(token.getSurface()+" ");
                    }
                    System.out.print(i+"\n");
                     bw.write(str_sp.toString() + "\n");
                }

                br.close();
                reader.close();
                System.out.print("ok");


                 bw.close();
                 writer.close();

            }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }
            catch(IOException e) {
                e.printStackTrace();
            }

        }



}
