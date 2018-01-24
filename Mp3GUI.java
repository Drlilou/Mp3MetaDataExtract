import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Optional;

public class Mp3GUI extends JFrame implements  ActionListener {
    private JTextField input;
    private  JTextArea out;
    private JButton submit1;
    private JLabel search;
    private JFrame root;

    Mp3GUI() {
        root = new JFrame("MUSIC META DATA");

        //output
        out = new JTextArea();
        out.setBounds(50, 120, 400, 150);
        out.setEditable(false);
        out.setFont(new Font("Serif", Font.ITALIC, 17));
        out.setForeground(Color.blue);
        out.setBackground(new Color(182,175,175));


        //input
        input = new JTextField();
        input.setBounds(155, 30, 180, 25);
        input.setFont(new Font("Times New Roman", Font.ITALIC, 17));

        submit1 = new JButton("Submit");
        submit1.setBounds(50, 80, 100, 30);
        submit1.addActionListener(this);


        search = new JLabel("Enter song name: ");
        search.setBounds(30, 30, 150, 20);
        search.setFont(new Font("Serif", Font.ITALIC, 17));


        root.add(search);
        root.add(input);

        root.add(submit1);

        root.add(out);

        root.setSize(500, 400);
        root.setLayout(null);
        root.setVisible(true);
        root.setBackground(new Color(182,175,175));
        root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String s1 = input.getText().trim();  // noo dude
        out.setText("");
        try {
            if (s1.isEmpty()) {
                JOptionPane.showMessageDialog(root,"feed some input :)");
            }
            else {
                Optional<MusicFileData> data = new FilesPrinter().searchAndPrintFileDetails(s1);
                if(data.isPresent())// problem idhi nul handling
                {
                    out.append("\n");
                    out.append(" Title -> " + data.get().getTitle()+ "\n");
                    out.append(" Artist -> " + data.get().getArtist() + "\n");
                    out.append(" Composer -> " + data.get().getComposer() + "\n");
                    out.append(" Genre -> " + data.get().getGenre() + "\n");
                    out.append(" Album -> " + data.get().getAlbum() + "\n");

                }
                else
                {
                    JOptionPane.showMessageDialog(root,"sorry ,the file doesnt Exsit");
                }
            }
        } catch (IOException o) {
            o.printStackTrace();
        }

    }
}