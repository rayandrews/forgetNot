package org.ensure.forgetnot.view;

import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.optionpane.WebOptionPane;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;
import org.ensure.forgetnot.core.Database;
import org.ensure.forgetnot.model.User;
import org.ensure.forgetnot.utility.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.Box;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Kelas Register.
 * @author Girvandi
 */
public class RegisterView extends View {
  static final Logger logger = LoggerFactory.getLogger(RegisterView.class);
  private Dialog dialog;
  private WebButton test;

  /**
   * Konstruktor.
   *
   * @param componentName menerima nama komponen
   */
  public RegisterView(String componentName) {
    super(componentName);
    //Dialog dialog = new Dialog(new Button());
    test = new WebButton("Register");
    test.addActionListener(new Dialog());
  }

  /**
   * Konstruktor dengan parameter.
   *
   * @param componentName        nama komponen
   * @param componentDescription deskripsi komponen
   */
  public RegisterView(String componentName, String componentDescription) {
    super(componentName, componentDescription);
  }

  /**
   * Konstruktor dengan parameter.
   *
   * @param componentName        nama komonen
   * @param componentDescription Deskripsi komeponen
   * @param dataInput            List pair key - value
   */
  public RegisterView(String componentName,
                      String componentDescription,
                      List<Pair<String, Object>> dataInput
  ) {
    super(componentName, componentDescription, dataInput);
  }

  /**
   * Konstruktor.
   *
   * @param dataInput Input data yang akan digunakan
   */
  public RegisterView(List<Pair<String, Object>> dataInput) {
    super(dataInput);
  }

  /*
    private class Dialog1 extends WebDialog {
      public Dialog1(Button owner) {
        super(owner, "Register");
        setDefaultCloseOperation(WebDialog.DISPOSE_ON_CLOSE);
        setResizable(true);
        setModal(true);

        TableLayout layout = new TableLayout(new double[][]{{TableLayout.PREFERRED, TableLayout.FILL},
          {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}});
        layout.setHGap(5);
        layout.setVGap(5);
        WebPanel content1 = new WebPanel(layout);

        content1.setMargin(15, 30, 15, 30);
        content1.setOpaque(false);
        content1.add(new WebLabel("Username", WebLabel.TRAILING), "0,0");
        WebTextField username = new WebTextField(15);
        username.setInputPrompt("Enter Username..");
        username.setInputPromptFont ( username.getFont ().deriveFont ( Font.ITALIC ) );
        content1.add(username, "1,0");
        content1.add(new WebLabel("Password", WebLabel.TRAILING), "0,1");
        WebPasswordField password = new WebPasswordField(15);
        password.setInputPrompt("Enter Password..");
        password.setInputPromptFont ( password.getFont ().deriveFont ( Font.ITALIC ) );
        content1.add(password, "1,1");
        WebButton next = new WebButton("Next");
        ActionListener listener = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Dialog2 dialog2 = new Dialog2(new Button());
          }
        };
        next.addActionListener(listener);
        content1.add(new CenterPanel(new GroupPanel(5, next)), "0,2");
        add(content1);
        center();
      }
    }

    private class Dialog2 extends WebDialog {
      public Dialog2(Button owner) {
        super(owner,"Register");
        String[] arr = new String[5];
        arr[0] = WebOptionPane.showInputDialog(
          null,
          "Enter Username",
          "Register",
          WebOptionPane.QUESTION_MESSAGE);
        arr[1] = WebOptionPane.showInputDialog(
          null,
          "Enter Password",
          "Register",
          WebOptionPane.QUESTION_MESSAGE);
        arr[2] = WebOptionPane.showInputDialog(
          null,
          "Enter First Name",
          "Register",
          WebOptionPane.QUESTION_MESSAGE);
        arr[3] = WebOptionPane.showInputDialog(
          null,
          "Enter Last Name",
          "Register",
          WebOptionPane.QUESTION_MESSAGE);
        arr[4] = WebOptionPane.showInputDialog(
          null,
          "Enter Email",
          "Register",
          WebOptionPane.QUESTION_MESSAGE);


        setDefaultCloseOperation(WebDialog.DISPOSE_ON_CLOSE);
        setResizable(true);
        setModal(true);

        TableLayout layout = new TableLayout(new double[][]{{TableLayout.PREFERRED, TableLayout.FILL},
          {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}});
        layout.setHGap(5);
        layout.setVGap(5);
        WebPanel content1 = new WebPanel(layout);

        content1.setMargin(15, 30, 15, 30);
        content1.setOpaque(false);
        content1.add(new WebLabel("First Name", WebLabel.TRAILING), "0,0");
        WebTextField firstName = new WebTextField(15);
        firstName.setInputPrompt("Enter First Name..");
        firstName.setInputPromptFont ( firstName.getFont ().deriveFont ( Font.ITALIC ) );
        content1.add(firstName, "1,0");
        content1.add(new WebLabel("Last Name", WebLabel.TRAILING), "0,1");
        WebTextField lastName = new WebTextField(15);
        lastName.setInputPrompt("Enter Last Name..");
        lastName.setInputPromptFont ( lastName.getFont ().deriveFont ( Font.ITALIC ) );
        content1.add(lastName, "1,1");
        WebButton next = new WebButton("Next");
        ActionListener listener = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Dialog3 dialog3 = new Dialog3(new Button());
          }
        };
        next.addActionListener(listener);
        content1.add(new CenterPanel(new GroupPanel(5, next)), "0,2");
        add(content1);
        center();

      }
    }

    private class Dialog3 extends WebDialog {
      public Dialog3(Button owner) {
        setDefaultCloseOperation(WebDialog.DISPOSE_ON_CLOSE);
        setResizable(true);
        setModal(true);

        TableLayout layout = new TableLayout(new double[][]{{TableLayout.PREFERRED, TableLayout.FILL},
          {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}});
        layout.setHGap(5);
        layout.setVGap(5);
        WebPanel content1 = new WebPanel(layout);

        content1.setMargin(15, 30, 15, 30);
        content1.setOpaque(false);
        content1.add(new WebLabel("Email", WebLabel.TRAILING), "0,0");
        WebTextField email = new WebTextField(15);
        email.setInputPrompt("Enter Email..");
        email.setInputPromptFont ( email.getFont ().deriveFont ( Font.ITALIC ) );
        content1.add(email, "1,0");
        WebButton register = new WebButton("Register");
        ActionListener listener = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            setVisible(false);
          }
        };
        register.addActionListener(listener);
        content1.add(new CenterPanel(new GroupPanel(5, register)), "0,2");
        add(content1);
        center();
      }
    }
    */
  @Override
  public Component init() {
    return test;
  }


  /**
   * Kelas Dialog untuk menampilkan dialog box sekaligus Action Listener.
   */
  private class Dialog implements ActionListener {
    private String[] arr = new String[5];

    /**
     * Konstruktor.
     */
    public Dialog() {
      super();
      Box boxContainer = Box.createVerticalBox();
      Box boxUsername = Box.createHorizontalBox();
      WebTextField username = new WebTextField(25);
      boxUsername.add(new WebLabel("Username  : "));
      boxUsername.add(username);
      boxContainer.add(boxUsername);

      Box boxPassword = Box.createHorizontalBox();
      WebPasswordField password = new WebPasswordField(15);
      boxPassword.add(new WebLabel(" Password  : "));
      boxPassword.add(password);
      boxContainer.add(boxPassword);

      Box boxEmail = Box.createHorizontalBox();
      WebTextField email = new WebTextField(25);
      boxEmail.add(new WebLabel("Email     : "));
      boxEmail.add(email);
      boxContainer.add(boxEmail);

      Box boxFirstname = Box.createHorizontalBox();
      WebTextField firstname = new WebTextField(25);
      boxFirstname.add(new WebLabel("Firstname : "));
      boxFirstname.add(firstname);
      boxContainer.add(boxFirstname);

      Box boxLastname = Box.createHorizontalBox();
      WebTextField lastname = new WebTextField(25);
      boxLastname.add(new WebLabel("Lastname  : "));
      boxLastname.add(lastname);
      boxContainer.add(boxLastname);

      if (WebOptionPane.showConfirmDialog(
          null,
          boxContainer,
          "Enter Username",
          WebOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
        arr[0] = username.getText();
        arr[1] = String.valueOf(password.getPassword());
        arr[2] = firstname.getText();
        arr[3] = lastname.getText();
        arr[4] = email.getText();
        String timeStamp = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );
        Database.connect();
        for (String a : arr) {
          logger.info(a);
        }
        User.createUser(arr[0], arr[1], arr[2], arr[3], arr[4], timeStamp);
        Database.close();
      }
    }

    @Override
    public void actionPerformed(ActionEvent event) {

    }
  }
}