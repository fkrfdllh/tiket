/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.view.authenticated;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import tiket.controller.EventController;
import tiket.controller.StageController;
import tiket.controller.TicketCategoryController;
import tiket.controller.TicketRegistrationController;
import tiket.model.Event;
import tiket.model.Stage;
import tiket.model.TicketCategory;
import tiket.model.TicketRegistration;

/**
 *
 * @author fkrfd
 */
public class RegistrationForm extends javax.swing.JFrame {
    
    private TicketCategory ticket = new TicketCategory();

    private final EventController eventController = new EventController();

    private final StageController stageController = new StageController();
    
    private final TicketCategoryController ticketController = new TicketCategoryController();

    private final TicketRegistrationController registrationController = new TicketRegistrationController();

    private DefaultTableModel tableModel;

    private DefaultComboBoxModel eventCB;

    private DefaultComboBoxModel stageCB;
    
    private DefaultComboBoxModel ticketCB;

    /**
     * Creates new form RegistrationForm
     */
    public RegistrationForm() {
        initComponents();

        setRegistrationTable();
        populateCBEvent();
        resetInput();
        
        ticketTotalListener();
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

    private void setRegistrationTable() {
        Object[] header = {"ID", "ID Event", "Nama Event", "ID Stage", "Nama Stage", "ID Tiket", "Nama Lengkap", "Alamat", "Email", "Total Tiket", "Harga Total", "Waktu Registrasi"};

        tableModel = new DefaultTableModel(null, header);
        tblRegistration.setModel(tableModel);

        populateTable();
    }

    private void populateTable() {
        List<TicketRegistration> registrations = registrationController.getAll();

        registrations.forEach((registration) -> {
            Object[] data = {
                registration.getId(),
                registration.getEvent().getId(),
                registration.getEvent().getName(),
                registration.getStage().getId(),
                registration.getStage().getName(),
                registration.getTicketCategory().getId(),
                registration.getName(),
                registration.getAddress(),
                registration.getEmail(),
                registration.getTicketTotal(),
                registration.getPriceTotal(),
                registration.getOrderedAt()
            };

            tableModel.addRow(data);
        });
    }

    private void resetInput() {
        txtId.setText("");
        cbEvent.setSelectedIndex(0);
        cbStage.setSelectedIndex(0);
        cbTicket.setSelectedIndex(0);
        txtName.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        txtTicketTotal.setText("");
        txtPriceTotal.setText("0");
    }

    private void populateCBEvent() {
        eventCB = new DefaultComboBoxModel();
        cbEvent.setModel(eventCB);

        List<Event> events = eventController.getAll();

        events.forEach((event) -> {
            eventCB.addElement(event.getId() + " " + event.getName());
        });
    }

    private void populateCBStage(int eventId) {
        stageCB = new DefaultComboBoxModel();
        cbStage.setModel(stageCB);

        List<Stage> stages = stageController.getAll(eventId);

        stages.forEach((stage) -> {
            cbStage.addItem(stage.getId() + " " + stage.getName());
        });
    }
    
    private void populateCBTicket(int eventId, int stageId) {
        ticketCB = new DefaultComboBoxModel();
        cbTicket.setModel(ticketCB);

        List<TicketCategory> tickets = ticketController.getAll(eventId, stageId);

        tickets.forEach((ticket) -> {
            cbTicket.addItem(ticket.getId() + " " + ticket.getName());
        });
    }
    
    private void ticketTotalListener() {
        txtTicketTotal.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                txtPriceTotal.setText(calcPirce());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                txtPriceTotal.setText("0");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                txtPriceTotal.setText(calcPirce());
            }
        });
    }
    
    private String calcPirce() {
        int ticketTotal = new Integer(txtTicketTotal.getText());
        int price = ticket.getPrice();
        
        return String.valueOf(ticketTotal * price);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistration = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbEvent = new javax.swing.JComboBox<>();
        cbStage = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbTicket = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTicketTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPriceTotal = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        txtId.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1366, 768));

        tblRegistration.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRegistration);

        jLabel10.setText("Dashboard >");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Registrasi Tiket");

        jLabel2.setText("Pilih Event");

        cbEvent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEvent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEventItemStateChanged(evt);
            }
        });

        cbStage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbStage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbStageItemStateChanged(evt);
            }
        });

        jLabel3.setText("Pilih Stage");

        jLabel4.setText("Pilih Tiket");

        cbTicket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTicket.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTicketItemStateChanged(evt);
            }
        });

        jLabel5.setText("Nama Lengkap");

        jLabel6.setText("Alamat");

        txtAddress.setColumns(20);
        txtAddress.setRows(3);
        jScrollPane2.setViewportView(txtAddress);

        jLabel7.setText("Email");

        jLabel8.setText("Total Pembelian Tiket");

        txtTicketTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTicketTotalKeyTyped(evt);
            }
        });

        jLabel9.setText("Total Harga");

        txtPriceTotal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtPriceTotal.setText("Total Harga");

        btnSubmit.setText("Registrasi");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel11.setText("Rp");

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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(cbEvent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(cbStage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtName)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel7)
                            .addComponent(txtEmail)
                            .addComponent(cbTicket, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPriceTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTicketTotal)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(184, 184, 184))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTicketTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbStage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPriceTotal)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubmit))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbEventItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEventItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String temp = evt.getItem().toString();
            int eventId = new Integer(temp.split(" ")[0]);

            populateCBStage(eventId);
        }
    }//GEN-LAST:event_cbEventItemStateChanged

    private void cbStageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbStageItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String temp1 = cbEvent.getSelectedItem().toString();
            int eventId = new Integer(temp1.split(" ")[0]);
            
            String temp2 = evt.getItem().toString();
            int stageId = new Integer(temp2.split(" ")[0]);

            populateCBTicket(eventId, stageId);
        }
    }//GEN-LAST:event_cbStageItemStateChanged

    private void txtTicketTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTicketTotalKeyTyped
        numberOnly(evt);
    }//GEN-LAST:event_txtTicketTotalKeyTyped

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        int eventId = new Integer(cbEvent.getSelectedItem().toString().split(" ")[0]);
        int stageId = new Integer(cbStage.getSelectedItem().toString().split(" ")[0]);
        int ticketId = new Integer(cbTicket.getSelectedItem().toString().split(" ")[0]);
                
        boolean response = registrationController.register(eventId, stageId, ticketId, txtName.getText(), txtAddress.getText(), txtEmail.getText(), new Integer(txtTicketTotal.getText()), new Integer(txtPriceTotal.getText()));
        
        if (!response) {
            showMessage("Terjadi kesalahan, silahkan coba lagi");
            return;
        }
        
        showMessage("Berhasil registrasi tiket");
        setRegistrationTable();
        resetInput();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void cbTicketItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTicketItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String temp = cbTicket.getSelectedItem().toString();
            int ticketId = new Integer(temp.split(" ")[0]);

            ticket = ticketController.get(ticketId);
        }
    }//GEN-LAST:event_cbTicketItemStateChanged

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
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbEvent;
    private javax.swing.JComboBox<String> cbStage;
    private javax.swing.JComboBox<String> cbTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable tblRegistration;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JLabel txtPriceTotal;
    private javax.swing.JTextField txtTicketTotal;
    // End of variables declaration//GEN-END:variables
}
