/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.ziceck.crypto.examples;

import io.github.ziceck.crypto.Atbash;
import io.github.ziceck.crypto.exception.AtbashException;

/**
 *
 * @author Ziceck
 */
public class TestAtbash {
    public static void main(String[] args) throws AtbashException {
        Atbash atbash=new Atbash(150,200);
        System.out
                .println(
                 atbash
                 .encrypt("Mensaje Encriptado"));
        System.out
                .println(
                atbash
                .decrypt(atbash
                .encrypt("Mensaje Encriptado")));
    }
    
}
