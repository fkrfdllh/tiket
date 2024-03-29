/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.view.authenticated.event;

import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tiket.controller.EventController;
import tiket.controller.StageController;
import tiket.helper.DTHelper;
import tiket.model.Event;
import tiket.model.Stage;
import tiket.view.authenticated.event.stage.PerformanceForm;
import tiket.view.authenticated.event.stage.TicketForm;

/**
 *
 * @author fkrfd
 */
public class StageForm extends javax.swing.JFrame {
    
    private Event event = new Event();
    
    private final EventController eventController = new EventController();
    
    private final StageController stageController = new StageController();
    
    private final DTHelper dtHelper = new DTHelper();

    private DefaultTableModel tableModel;

    /**
     * Creates new form StageForm
     */
    public StageForm(int eventId) {
        initComponents();
                
        event = eventController.get(eventId);
        
        lblEventName.setText(event.getName());
                
        setStageTable();
        resetInput();
    }

    private StageForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void timeOnly(KeyEvent event) {
        char c = event.getKeyChar();

        if (!(Character.isDigit(c)) && c != ':') {
            event.consume();
        }
    }
    
    private void numberOnly(KeyEvent event) {
        char c = event.getKeyChar();
        
        if (!(Character.isDigit(c))) {
            event.consume();
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void setStageTable() {
        Object[] tableHeader = {"ID Stage", "Nama Event", "Nama Stage", "Nomor Stage", "Lokasi Stage", "Waktu Mulai", "Waktu Selesai"};
        tableModel = new DefaultTableModel(null, tableHeader);
        tblStage.setModel(tableModel);

        populateTable();
    }

    private void populateTable() {
        List<Stage> stages = stageController.getAll(event.getId());

        stages.forEach((stage) -> {
            Object[] data = {
                stage.getId(),
                stage.getEvent(),
                stage.getName(),
                stage.getNumber(),
                stage.getLocation(),
                stage.getStartedAt(),
                stage.getFinishedAt()
            };

            tableModel.addRow(data);
        });
    }

    private void resetInput() {
        txtId.setText("");
        txtName.setText("");
        txtNumber.setText("");
        txtLocation.setText("");
        txtStartedDate.setDate(new Date());
        txtStartedTime.setText("");
        txtFinishedDate.setDate(new Date());
        txtFinishedTime.setText("");

        btnToTicket.setEnabled(false);
        btnToPerformance.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStage = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblEventName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLocation = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtStartedDate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtStartedTime = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFinishedDate = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtFinishedTime = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnToTicket = new javax.swing.JButton();
        btnToPerformance = new javax.swing.JButton();

        txtId.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(1366, 768));

        jLabel10.setText("Dashboard >");

        jLabel1.setText("Manajemen Event >");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Manajemen Stage");

        tblStage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStageMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStage);

        jLabel3.setText("Stage dari event:");

        lblEventName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblEventName.setText("Foo");

        jLabel4.setText("Nama Stage");

        jLabel5.setText("Nomor Stage");

        txtNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumberKeyTyped(evt);
            }
        });

        jLabel6.setText("Lokasi Stage");

        txtLocation.setColumns(20);
        txtLocation.setRows(3);
        jScrollPane2.setViewportView(txtLocation);

        jLabel7.setText("Tanggal Mulai");

        txtStartedDate.setDateFormatString("yyyy-MM-dd");
        txtStartedDate.setMinSelectableDate(new Date());

        jLabel8.setText("Jam Mulai");

        txtStartedTime.setColumns(20);
        txtStartedTime.setRows(1);
        txtStartedTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStartedTimeKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtStartedTime);

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Contoh: 00:00");

        jLabel11.setText("Tanggal Selesai");

        txtFinishedDate.setDateFormatString("yyyy-MM-dd");
        txtFinishedDate.setMinSelectableDate(new Date());

        jLabel12.setText("Jam Selesai");

        txtFinishedTime.setColumns(20);
        txtFinishedTime.setRows(1);
        txtFinishedTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFinishedTimeKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(txtFinishedTime);

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Contoh: 23:59");

        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Ubah");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnToTicket.setText("Manajemen Tiket");
        btnToTicket.setEnabled(false);
        btnToTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToTicketActionPerformed(evt);
            }
        });

        btnToPerformance.setText("Manajemen Performance");
        btnToPerformance.setEnabled(false);
        btnToPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToPerformanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnToTicket)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnToPerformance))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lblEventName))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(txtName)
                                    .addComponent(jLabel5)
                                    .addComponent(txtNumber)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStartedDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(txtFinishedDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnToPerformance)
                        .addComponent(btnToTicket))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel10)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblEventName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStartedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFinishedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit)
                            .addComponent(btnAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberKeyTyped
        numberOnly(evt);
    }//GEN-LAST:event_txtNumberKeyTyped

    private void txtStartedTimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStartedTimeKeyTyped
        timeOnly(evt);
    }//GEN-LAST:event_txtStartedTimeKeyTyped

    private void txtFinishedTimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFinishedTimeKeyTyped
        timeOnly(evt);
    }//GEN-LAST:event_txtFinishedTimeKeyTyped

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        boolean response = stageController.insert(event.getId(), txtName.getText(), new Integer(txtNumber.getText()), txtLocation.getText(), txtStartedDate.getDate(), txtStartedTime.getText(), txtFinishedDate.getDate(), txtFinishedTime.getText());

        if (!response) {
            showMessage("Terjadi kesalahan saat menyimpan data, silahkan coba lagi");
            return;
        }

        showMessage("Berhasil menyimpan data");
        setStageTable();
        resetInput();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (txtId.getText().equals("")) {
            showMessage("Anda harus memilih data terlebih dahulu");
            return;
        }

        String startedDate = dtHelper.formatMysqlDate(txtStartedDate.getDate());
        String finishedDate = dtHelper.formatMysqlDate(txtFinishedDate.getDate());

        String startedAt = startedDate + " " + txtStartedTime.getText();
        String finishedAt = finishedDate + " " + txtFinishedTime.getText();

        Stage stage = new Stage();
        stage.setId(new Integer(txtId.getText()));
        stage.setEvent(event);
        stage.setName(txtName.getText());
        stage.setNumber(new Integer(txtNumber.getText()));
        stage.setLocation(txtLocation.getText());
        stage.setStartedAt(startedAt);
        stage.setFinishedAt(finishedAt);

        boolean response = stageController.update(stage);

        if (!response) {
            showMessage("Terjadi kesalahan saat mengubah data, silahkan coba lagi");
            return;
        }

        showMessage("Berhasil mengubah data");
        setStageTable();
        resetInput();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtId.getText().equals("")) {
            showMessage("Anda harus memilih data terlebih dahulu");
            return;
        }

        boolean response = stageController.delete(new Integer(txtId.getText()));

        if (!response) {
            showMessage("Terjadi kesalahan saat menghapus data, silahkan coba lagi");
            return;
        }

        showMessage("Berhasil menghapus data");
        setStageTable();
        resetInput();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetInput();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnToTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToTicketActionPerformed
        TicketForm ticketForm = new TicketForm(event.getId(), new Integer(txtId.getText()));
        ticketForm.setLocationRelativeTo(null);
        ticketForm.setVisible(true);
    }//GEN-LAST:event_btnToTicketActionPerformed

    private void btnToPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToPerformanceActionPerformed
        PerformanceForm performanceForm = new PerformanceForm(event.getId(), new Integer(txtId.getText()));
        performanceForm.setLocationRelativeTo(null);
        performanceForm.setVisible(true);
    }//GEN-LAST:event_btnToPerformanceActionPerformed

    private void tblStageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStageMouseClicked
        int row = tblStage.getSelectedRow();

        String id = tableModel.getValueAt(row, 0).toString();
        String name = tableModel.getValueAt(row, 2).toString();
        String number = tableModel.getValueAt(row, 3).toString();
        String location = tableModel.getValueAt(row, 4).toString();
        String startedAt = tableModel.getValueAt(row, 5).toString();
        String finishedAt = tableModel.getValueAt(row, 6).toString();

        String[] tempStartedAt = startedAt.split(" ");
        String[] tempFinishedAt = finishedAt.split(" ");

        Date startedDate = null;
        Date finishedDate = null;

        try {
            startedDate = new SimpleDateFormat("yyyy-MM-dd").parse(tempStartedAt[0]);
            finishedDate = new SimpleDateFormat("yyyy-MM-dd").parse(tempFinishedAt[0]);
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
        }

        String startedTime = dtHelper.setTimeFromDB(tempStartedAt[1]);
        String finishedTime = dtHelper.setTimeFromDB(tempFinishedAt[1]);

        txtId.setText(id);
        txtName.setText(name);
        txtNumber.setText(number);
        txtLocation.setText(location);
        txtStartedDate.setDate(startedDate);
        txtStartedTime.setText(startedTime);
        txtFinishedDate.setDate(finishedDate);
        txtFinishedTime.setText(finishedTime);

        btnToPerformance.setEnabled(true);
        btnToTicket.setEnabled(true);
    }//GEN-LAST:event_tblStageMouseClicked

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
            java.util.logging.Logger.getLogger(StageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StageForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnToPerformance;
    private javax.swing.JButton btnToTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblEventName;
    private javax.swing.JTable tblStage;
    private com.toedter.calendar.JDateChooser txtFinishedDate;
    private javax.swing.JTextArea txtFinishedTime;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtLocation;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumber;
    private com.toedter.calendar.JDateChooser txtStartedDate;
    private javax.swing.JTextArea txtStartedTime;
    // End of variables declaration//GEN-END:variables
}
