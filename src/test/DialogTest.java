package test;

import Dialog.Condition;
import Dialog.DialogInstance;
import Dialog.DialogLine;
import Dialog.Information;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DialogTest {

    @BeforeEach
    public void setup(){

    }

    @Test
    public void DialogLineAndInstanceTest(){
        DialogLine dialogLine1 = new DialogLine("test_1","Hello Stranger, What are you doing here?");
        DialogLine dialogLine2 = new DialogLine("test_2","Im just walking around");
        DialogLine dialogLine3 = new DialogLine("test_3","Did you know that vaporeon...");

        Condition<String> condition = new Condition<>();

        Information information = new Information();

        information.add(dialogLine1);
        information.add(dialogLine2);
        information.add(dialogLine3);

        //public DialogInstance(String description, int priority, boolean isPermanent, boolean isImportant, Condition condition, Runnable action, String nextId)
        DialogInstance Dialoginstance = new DialogInstance("Hello Stranger", 1,true,false, condition, information);

        Dialoginstance.run();

    }
}
