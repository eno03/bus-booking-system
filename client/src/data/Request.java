/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author wint4
 */
public class Request implements Serializable {

    public String funcName;
    public ArrayList<String> parametres;

    public Request() {
    }

    public Request(String funcName, ArrayList<String> parametres) {
        this.funcName = funcName;
        this.parametres = parametres;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public ArrayList<String> getParametres() {
        return parametres;
    }

    public void setParametres(ArrayList<String> parametres) {
        this.parametres = parametres;
    }

}
