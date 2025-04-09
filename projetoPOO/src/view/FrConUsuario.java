/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsuarioController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import utils.Utils;

/**
 *
 * @author iband
 */
public class FrConUsuario extends javax.swing.JDialog {

  /**
   * Creates new form FrConUsuario
   */
  public FrConUsuario(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    
    //Abre a tela centralizada
    this.setLocationRelativeTo(null);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    lblTitulo = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblUsuarios = new javax.swing.JTable();
    btnExcluir = new javax.swing.JButton();
    btnAlterar = new javax.swing.JButton();
    btnCancelar = new javax.swing.JButton();
    btnPesquisar = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Consulta de Usuário");

    jPanel1.setBackground(new java.awt.Color(153, 255, 255));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
    lblTitulo.setText("Consulta de Usuários");
    jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

    tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null}
      },
      new String [] {
        "Id", "Nome", "Email", "Data Nasc.", "Ativo"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tblUsuarios);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 670, 320));

    btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btnExcluir.setText("Excluir");
    btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnExcluirMouseClicked(evt);
      }
    });
    jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 520, -1, -1));

    btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btnAlterar.setText("Alterar");
    btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnAlterarMouseClicked(evt);
      }
    });
    jPanel1.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, -1, -1));

    btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btnCancelar.setText("Voltar");
    jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));

    btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btnPesquisar.setText("Pesquisar");
    btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnPesquisarMouseClicked(evt);
      }
    });
    jPanel1.add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_consultar.png"))); // NOI18N
    jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseClicked
    pesquisar();
  }//GEN-LAST:event_btnPesquisarMouseClicked

  public void pesquisar(){
    //Pega o modelo da grade com suas colunas
    // o 
    DefaultTableModel modeloTabela = (DefaultTableModel) tblUsuarios.getModel();

    //Limpa a grade setando o número de linhas para zero
    modeloTabela.setNumRows(0);

    //Cria um UsuarioController para poder acessar os dados de tbusuario
    UsuarioController controller = new UsuarioController();
    
    //consulta os usuários e guarda a lista de usuários que encontrou
    List<Usuario> listaUsuarios = controller.consultar();
    
    //Preencher a grade
    //percorre todos os usuários presentes na lista
    for (Usuario usu : listaUsuarios) {
      //cria um array onde cada posição é o valor das colunas da grade
      Object[] linha = {
        usu.getPkUsuario(), //coluna 0
        usu.getNome(), //coluna 1
        usu.getEmail(), //coluna 2
        Utils.converterDateToString(usu.getDataNasc()), //coluna 3
        usu.ativoToString() //coluna 4
      };
      
      //Adiciona o array com os dados do usuário na grade
      modeloTabela.addRow(linha);
    }
  }
  
  private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
    //Verificar se tem uma linha da grade selecionada
    if (tblUsuarios.getSelectedRow() != -1) {
      //Se tiver pegar o código do usuário da grade
      int linhaSelecionada = tblUsuarios.getSelectedRow();
      String textoCelula = tblUsuarios.getValueAt(linhaSelecionada, 0).toString();
      
      //converter o texto da célula em inteiro
      int pkUsuario = Integer.parseInt(textoCelula);
           
      //com o pkUsuario eu vou criar uma tela de  
      //alteração passando o pkUsuario
      
      //Essa tela irá carregar os dados desse usuário
      //para poder alterar     
      FrAltUsuario telaAlt = new FrAltUsuario(null,rootPaneCheckingEnabled, pkUsuario);
            
      telaAlt.setVisible(true);
      
      pesquisar();
    }
  }//GEN-LAST:event_btnAlterarMouseClicked

  private void btnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseClicked
    //Verificar se tem uma linha da grade selecionada
    if (tblUsuarios.getSelectedRow() != -1) {
      //Se tiver pegar o código do usuário da grade
      int linhaSelecionada = tblUsuarios.getSelectedRow();
      String textoCelula = tblUsuarios.getValueAt(linhaSelecionada, 0).toString();
      
      //converter o texto da célula em inteiro
      int pkUsuario = Integer.parseInt(textoCelula);
           
      //com o pkUsuario eu vou chamar um método de deletar no controller
      UsuarioController controller = new UsuarioController();
      if(controller.deletar(pkUsuario)){
        pesquisar();
        JOptionPane.showMessageDialog(rootPane, "Deletado com sucesso");
      }else {
        JOptionPane.showMessageDialog(rootPane, "Não foi deletado");
      }
    }
  }//GEN-LAST:event_btnExcluirMouseClicked

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(FrConUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(FrConUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(FrConUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(FrConUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        FrConUsuario dialog = new FrConUsuario(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
          @Override
          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAlterar;
  private javax.swing.JButton btnCancelar;
  private javax.swing.JButton btnExcluir;
  private javax.swing.JButton btnPesquisar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lblTitulo;
  private javax.swing.JTable tblUsuarios;
  // End of variables declaration//GEN-END:variables
}
