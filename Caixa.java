package caixa;

import javax.swing.JOptionPane;

public class Caixa {

    public static void main(String[] args) {
        String cpf = "12345678900", cpfUser;
        String senha = "01020304", senhaUser;
        int escolha = 1;
        int t = 0;
        int r = 2;
        float saldo = 1000, deposito, saque;

        cpfUser = JOptionPane.showInputDialog("Insira Seu CPF:", "Por favor digite seu CPF");

        if (cpfUser.equals(cpf)) {
            senhaUser = JOptionPane.showInputDialog("Insira Sua senha:", "Por favor digite sua senha:");

            do {

                if (senhaUser.equals(senha)) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "<html><font color=red face=arial> Senha incorreta.");
                    senhaUser = JOptionPane.showInputDialog("Inira sua senha Novamente: \nNumero de tentativas (" + r + ")", "Tente novamente");
                    t++;
                    r--;
                }
            } while (!senhaUser.equals(senha) && t < 2);

            if (!senhaUser.equals(senha)) {
                JOptionPane.showMessageDialog(null, "<html><font color=red face=arial> Acesso negado!");
            }

            if (senhaUser.equals(senha)) {
                while (escolha != 0) {
                    escolha = Integer.parseInt(JOptionPane.showInputDialog("Menu" + "\n1 -> Saldo" + "\n2 -> Depósito" + "\n3 -> Saque" + "\n0 -> Sair", "Escolha uma das opções"));

                    switch (escolha) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Seu saldo é de: " + saldo);

                            break;

                        case 2:
                            deposito = Float.parseFloat(JOptionPane.showInputDialog("Por favor insira um valor para o depósito:"));
                            if (deposito < 0) {
                                JOptionPane.showMessageDialog(null, "Insira um valor válido:");

                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "<html><font color=green face=arial> Depósito realizado com sucesso!");
                                saldo = deposito + saldo;

                                break;
                            }

                        case 3:
                            saque = Float.parseFloat(JOptionPane.showInputDialog("Digite um valor para realizar o saque:"));

                            if (saque > saldo || saque < 0) {
                                JOptionPane.showMessageDialog(null, "\nDigite um valor válido por favor");

                            } else {
                                JOptionPane.showMessageDialog(null, "<html><font color=green face=arial> Saque realizado com sucesso!!");
                                saldo = saldo - saque;

                            }
                            break;

                        case 0:
                            JOptionPane.showMessageDialog(null,"<html><font color=green face=arial> Saindo do sitema");
                            break;

                        default:
                            JOptionPane.showMessageDialog(null,"<html><font color=red face=arial> Número inválido");
                            break;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "<html><font color=red face=arial> Acesso Negado!");
        }
    }
}

