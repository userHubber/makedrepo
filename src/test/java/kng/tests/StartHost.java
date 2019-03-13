package kng.tests;

import kng.Domain;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class StartHost {

//    @BeforeGroups(groups = {"dev"})
//    public void setDev() {
//        Domain.setDEV();
//    }
//
//    @BeforeGroups(groups = {"pre"})
//    public void setPre() {
//        Domain.setPre();
//    }

    @BeforeGroups(groups = {"prod"})
    public void setProd() {
        Domain.setProd();
    }

//    @Test(groups = {"dev"})
//    public void startDev() {
//        System.out.println("StartDev");
//    }
//
//    @Test(groups = {"pre"})
//    public void startPre() {
//        System.out.println("StartPre");
//    }

    @Test(groups = {"prod"})
    public void startProd() {
        System.out.println("StartProd");
    }
}
