package cliente;

import DTOs.requests.*;
import DTOs.responses.*;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Produto;

public class ViewHome extends javax.swing.JFrame {

    public ViewHome(String cUsername, ViewClienteLogin viewClienteLogin, PrintWriter out, BufferedReader in) {
        initComponents();
        this.cUsername = cUsername;
        this.viewClienteLogin = viewClienteLogin;
        this.in = in;
        this.out = out;
        this.produtos = new ArrayList<Produto>();
        this.meusProdutos = new ArrayList<Produto>();
        AtualizarTodosProdutos();
        AtualizarMeusProdutos();
    }

    ArrayList<Produto> produtos;
    ArrayList<Produto> meusProdutos;

    ViewClienteLogin viewClienteLogin;
    String cUsername;
    Produto prodSelecionado;
    int idSelect = 0;
    PrintWriter out;
    BufferedReader in;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotaoSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        novoNomeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        novoValorField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        novaDescArea = new javax.swing.JTextArea();
        AddProdutoButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        AtualizarTodosButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        produtosTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editarNomeField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        editarValorField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        editarDescArea = new javax.swing.JTextArea();
        editarProdutoButton = new javax.swing.JButton();
        excluirProdutoButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        AtualizarMeusButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        meusProdutosTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labelNomeSelecionado = new javax.swing.JLabel();
        labelValorSelecionado = new javax.swing.JLabel();
        labelVendedorSelecionado = new javax.swing.JLabel();
        labelDescSelecionado = new javax.swing.JLabel();
        botaoComprar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        BotaoSair.setText("Sair");
        BotaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSairActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Novo Produto");

        jLabel2.setText("Nome:");

        novoNomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoNomeFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor:");

        jLabel4.setText("Descrição:");

        novaDescArea.setColumns(20);
        novaDescArea.setRows(5);
        jScrollPane1.setViewportView(novaDescArea);

        AddProdutoButton.setText("Adicionar");
        AddProdutoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProdutoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(novoNomeField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(novoValorField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddProdutoButton)
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(novoNomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(novoValorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddProdutoButton)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Todos os Produtos");

        AtualizarTodosButton.setText("Atualizar");
        AtualizarTodosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarTodosButtonActionPerformed(evt);
            }
        });

        produtosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Valor", "Vendedor"
            }
        ));
        produtosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                produtosTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(produtosTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AtualizarTodosButton)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(AtualizarTodosButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Produto Selecionado para Edição");

        jLabel7.setText("Nome:");

        jLabel8.setText("Valor:");

        jLabel9.setText("Descrição:");

        editarDescArea.setColumns(20);
        editarDescArea.setRows(5);
        jScrollPane3.setViewportView(editarDescArea);

        editarProdutoButton.setText("Editar");
        editarProdutoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarProdutoButtonActionPerformed(evt);
            }
        });

        excluirProdutoButton.setText("Excluir");
        excluirProdutoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirProdutoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editarNomeField))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editarValorField))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(excluirProdutoButton)
                .addGap(18, 18, 18)
                .addComponent(editarProdutoButton)
                .addGap(71, 71, 71))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(editarNomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(editarValorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 97, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarProdutoButton)
                    .addComponent(excluirProdutoButton))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Meus Produtos");

        AtualizarMeusButton.setText("Atualizar");
        AtualizarMeusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarMeusButtonActionPerformed(evt);
            }
        });

        meusProdutosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor"
            }
        ));
        meusProdutosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                meusProdutosTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(meusProdutosTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(AtualizarMeusButton)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(AtualizarMeusButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Produto Selecionado");

        jLabel12.setText("Nome:");

        jLabel13.setText("Valor:");

        jLabel14.setText("Descrição:");

        jLabel15.setText("Vendedor:");

        botaoComprar.setText("Comprar");
        botaoComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNomeSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelVendedorSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDescSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(botaoComprar)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNomeSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(labelValorSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(labelVendedorSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(labelDescSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoComprar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoSair, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotaoSair)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSairActionPerformed
        try {
            Gson gson = new Gson();
            LogoutRequestDTO logoutRequest = new LogoutRequestDTO();
            logoutRequest.setOp(200);
            logoutRequest.setUsername(cUsername);
            System.out.printf("\n\nMensagem Enviada para o Server : " + gson.toJson(logoutRequest) + "\n\n");
            out.println(gson.toJson(logoutRequest));
            String resposta = in.readLine();
            System.out.println("Servidor respondeu : " + resposta);
            DefaultResponse respostaJson = gson.fromJson(resposta, DefaultResponse.class);
            if (respostaJson.getStatus() == 201) {
                this.setVisible(false); // Desaparece tela login
                viewClienteLogin.setVisible(true);
                JOptionPane.showMessageDialog(null, "Sucesso, " + resposta, "Logout", 1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro", "Logout", 1);
            //Logger.getLogger(ViewHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoSairActionPerformed

    private void novoNomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoNomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novoNomeFieldActionPerformed

    private void AtualizarTodosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarTodosButtonActionPerformed
        AtualizarTodosProdutos();
    }//GEN-LAST:event_AtualizarTodosButtonActionPerformed

    private void excluirProdutoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirProdutoButtonActionPerformed
        try {
            Gson gson = new Gson();
            DeleteRequest removeRequest = new DeleteRequest();
            // Setando campos
            removeRequest.setOp(1000); // op
            removeRequest.setProductId(idSelect); // id
            removeRequest.setUsername(cUsername); // username
            // Enviando mensagem
            System.out.printf("\n\nMensagem Enviada para o Server : " + gson.toJson(removeRequest) + "\n\n");
            out.println(gson.toJson(removeRequest));
            // Recebendo resposta
            String resposta = in.readLine();
            System.out.println("Servidor respondeu : " + resposta);
            // Tratando resposta
            DefaultResponse respostaJson = gson.fromJson(resposta, DefaultResponse.class);
            if (respostaJson.getStatus() == 1001) {
                AtualizarTodosProdutos(); // atualiza todos
                AtualizarMeusProdutos(); // atualiza meus
                cleanEdit();
                idSelect = 0;
                JOptionPane.showMessageDialog(null, "Sucesso, " + resposta, "Excluir Produto", 1);
            } else if (respostaJson.getStatus() == 802) {
                JOptionPane.showMessageDialog(null, "Falha, " + resposta, "Excluir Produto", 1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro", "Excluir Produto", 1);
            //Logger.getLogger(ViewHome.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_excluirProdutoButtonActionPerformed

    private void AtualizarMeusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarMeusButtonActionPerformed
        AtualizarMeusProdutos();
    }//GEN-LAST:event_AtualizarMeusButtonActionPerformed

    private void editarProdutoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarProdutoButtonActionPerformed
       try {
            Gson gson = new Gson();
            EditRequest editRequest = new EditRequest();
            // Setando campos
            editRequest.setOp(900); // op
            editRequest.setProductId(idSelect); // id
            editRequest.setProductName(editarNomeField.getText()); // nome
            editRequest.setProductValue(Float.parseFloat(editarValorField.getText())); // valor
            editRequest.setDescription(editarDescArea.getText()); // descricao
            // Enviando mensagem
            System.out.printf("\n\nMensagem Enviada para o Server : " + gson.toJson(editRequest) + "\n\n");
            out.println(gson.toJson(editRequest));
            // Recebendo resposta
            String resposta = in.readLine();
            System.out.println("Servidor respondeu : " + resposta);
            // Tratando resposta
            DefaultResponse respostaJson = gson.fromJson(resposta, DefaultResponse.class);
            if (respostaJson.getStatus() == 901) {
                AtualizarTodosProdutos(); // atualiza todos
                AtualizarMeusProdutos(); // atualiza meus
                cleanEdit();
                idSelect = 0;
                JOptionPane.showMessageDialog(null, "Sucesso, " + resposta, "Editar Produto", 1);
            } else if (respostaJson.getStatus() == 902) {
                JOptionPane.showMessageDialog(null, "Falha, " + resposta, "Editar Produto", 1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro", "Editar Produto", 1);
            //Logger.getLogger(ViewHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editarProdutoButtonActionPerformed

    private void AddProdutoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProdutoButtonActionPerformed
        if (novoNomeField.getText().equals("") || novoValorField.getText().equals("") || novaDescArea.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos os campos", "Adicionar Produto", 1);
        } else {
            try {
                Gson gson = new Gson();
                NewProductRequest newProductRequest = new NewProductRequest();
                // Setando campos
                newProductRequest.setOp(800); // op
                newProductRequest.setName(novoNomeField.getText()); // nome
                newProductRequest.setProductValue(Float.parseFloat(novoValorField.getText())); // valor
                newProductRequest.setDescription(novaDescArea.getText()); // descricao
                // Enviando mensagem
                System.out.printf("\n\nMensagem Enviada para o Server : " + gson.toJson(newProductRequest) + "\n\n");
                out.println(gson.toJson(newProductRequest));
                // Recebendo resposta
                String resposta = in.readLine();
                System.out.println("Servidor respondeu : " + resposta);
                // Tratando resposta
                DefaultResponse respostaJson = gson.fromJson(resposta, DefaultResponse.class);
                if (respostaJson.getStatus() == 801) {
                    AtualizarTodosProdutos(); // atualiza todos
                    AtualizarMeusProdutos(); // atualiza meus
                    cleanNovo();
                    JOptionPane.showMessageDialog(null, "Sucesso, " + resposta, "Adicionar Produto", 1);
                } else if (respostaJson.getStatus() == 802) {
                    JOptionPane.showMessageDialog(null, "Falha, " + resposta, "Adicionar Produto", 1);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro", "Adicionar Produto", 1);
                //Logger.getLogger(ViewHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_AddProdutoButtonActionPerformed

    private void meusProdutosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meusProdutosTableMouseClicked
        int linha = this.meusProdutosTable.getSelectedRow();
        int id = Integer.parseInt((String) this.meusProdutosTable.getValueAt(linha, 0));
        idSelect = id;
        System.out.println("Entrou " + linha);

        Produto p = retornaPeloID(id, meusProdutos);
        editarNomeField.setText(p.getName());
        editarValorField.setText(String.valueOf(p.getValue()));
        editarDescArea.setText(p.getDescription());
    }//GEN-LAST:event_meusProdutosTableMouseClicked

    private void botaoComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoComprarActionPerformed
        if(prodSelecionado != null) 
        {
            String userComprador = cUsername;
            String userVendedor = prodSelecionado.getUser_username();
            System.out.println("Usuário " + userComprador + " quer comprar o produto " + prodSelecionado.getName() + " de " + userVendedor);
        }
    }//GEN-LAST:event_botaoComprarActionPerformed

    private void produtosTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtosTableMouseClicked
        int linha = this.produtosTable.getSelectedRow();
        prodSelecionado = produtos.get(linha);
        if(prodSelecionado != null)
        {
            labelNomeSelecionado.setText(prodSelecionado.getName());
            labelValorSelecionado.setText(String.valueOf(prodSelecionado.getValue()));
            labelDescSelecionado.setText(prodSelecionado.getDescription());
            labelVendedorSelecionado.setText(prodSelecionado.getUser_username());
        }
    }//GEN-LAST:event_produtosTableMouseClicked

    private void AtualizarTodosProdutos() {
        try {
            Gson gson = new Gson();
            DefaultRequest todosProdutosRequest = new DefaultRequest();
            todosProdutosRequest.setOp(400);
            System.out.printf("\n\nMensagem Enviada para o Server : " + gson.toJson(todosProdutosRequest) + "\n\n");
            out.println(gson.toJson(todosProdutosRequest));
            String resposta = in.readLine();
            System.out.println("Servidor respondeu : " + resposta);
            ProductsResponse respostaJson = gson.fromJson(resposta, ProductsResponse.class);
            if (respostaJson.getStatus() == 401) {
                produtos = respostaJson.getProductArray();
                AtualizaTabelaTodos();
                //JOptionPane.showMessageDialog(null, "Sucesso, " + resposta, "Atualizar todos os produtos", 1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro", "Atualizar todos os produtos", 1);
            //Logger.getLogger(ViewHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void AtualizarMeusProdutos() {
        try {
            Gson gson = new Gson();
            DefaultRequest meusProdutosRequest = new DefaultRequest();
            meusProdutosRequest.setOp(500);
            System.out.printf("\n\nMensagem Enviada para o Server : " + gson.toJson(meusProdutosRequest) + "\n\n");
            out.println(gson.toJson(meusProdutosRequest));
            String resposta = in.readLine();
            System.out.println("Servidor respondeu : " + resposta);
            ProductsResponse respostaJson = gson.fromJson(resposta, ProductsResponse.class);
            if (respostaJson.getStatus() == 501) {
                meusProdutos = respostaJson.getProductArray();
                AtualizaTabelaMeus();
                //JOptionPane.showMessageDialog(null, "Sucesso, " + resposta, "Atualizar todos os produtos", 1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro", "Atualizar meus os produtos", 1);
            //Logger.getLogger(ViewHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void AtualizaTabelaTodos() {
        Produto p;

        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel) produtosTable.getModel();
        dtm.fireTableDataChanged(); // limpando
        dtm.setRowCount(0); // começa pela linha 0

        for (int cont = 0; cont < produtos.size(); cont++) {
            p = produtos.get(cont);
            String[] data
                    = {
                        "" + p.getName(),
                        "" + String.valueOf(p.getValue()),
                        "" + p.getUser_username()
                    };
            dtm.addRow(data);
        }
    }

    private void AtualizaTabelaMeus() {
        Produto p;

        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel) meusProdutosTable.getModel();
        dtm.fireTableDataChanged(); // limpando
        dtm.setRowCount(0); // começa pela linha 0

        for (int cont = 0; cont < meusProdutos.size(); cont++) {
            p = meusProdutos.get(cont);
            String[] data
                    = {
                        "" + p.getIdproduct(),
                        "" + p.getName(),
                        "" + String.valueOf(p.getValue())

                    };
            dtm.addRow(data);
        }
    }

    private Produto retornaPeloID(int id, ArrayList<Produto> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdproduct() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    private void cleanNovo() {
        novoNomeField.setText("");
        novoValorField.setText("");
        novaDescArea.setText("");
    }

    private void cleanEdit() {
        editarNomeField.setText("");
        editarValorField.setText("");
        editarDescArea.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProdutoButton;
    private javax.swing.JButton AtualizarMeusButton;
    private javax.swing.JButton AtualizarTodosButton;
    private javax.swing.JButton BotaoSair;
    private javax.swing.JButton botaoComprar;
    private javax.swing.JTextArea editarDescArea;
    private javax.swing.JTextField editarNomeField;
    private javax.swing.JButton editarProdutoButton;
    private javax.swing.JTextField editarValorField;
    private javax.swing.JButton excluirProdutoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelDescSelecionado;
    private javax.swing.JLabel labelNomeSelecionado;
    private javax.swing.JLabel labelValorSelecionado;
    private javax.swing.JLabel labelVendedorSelecionado;
    private javax.swing.JTable meusProdutosTable;
    private javax.swing.JTextArea novaDescArea;
    private javax.swing.JTextField novoNomeField;
    private javax.swing.JTextField novoValorField;
    private javax.swing.JTable produtosTable;
    // End of variables declaration//GEN-END:variables
}
