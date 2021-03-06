import org.junit.Test;

import core.*;
import attack.*;

public class winlogonHelperDLLTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        Administrator administrator = new Administrator("administrator");
        Windows windows = new Windows("windows", true);

        // Section 2: Asset connections and attacker creation
        administrator.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertUncompromised();
        windows.runOnLogsOn.assertUncompromised();

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        Administrator administrator = new Administrator("administrator");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        administrator.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneously();
        windows.runOnLogsOn.assertCompromisedInstantaneously();
        
    }
}