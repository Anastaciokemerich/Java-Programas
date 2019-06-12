private void btChamarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:

            senha  novo = new senha();
            novo.GeraSenha();
            label1.Text = "Atendimento Prioritário";
            label2.Text =" Senha: " +novo.GeraSenha();
        }
}
