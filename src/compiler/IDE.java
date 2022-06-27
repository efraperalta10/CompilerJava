/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author efrap
 */
public class IDE extends javax.swing.JFrame {
    
    NumeroLinea numeroLinea;
    Directorio dir;

    /**
     * Creates new form IDE
     */
    public IDE() {
        initComponents();
        inicializar();
        colors();
    }
    
    //Metodo para encontrar las ultimas cadenas
    private int findLastNonWordChar(String text, int index){
        while(--index >= 0){
            // \\W = [A-Za-z0-9]
            if(String.valueOf(text.charAt(index)).matches("\\W")){
                break;
            }
        }
        return index;
    }
    
    //Metodo para encontrar las primeras cadenas
    private int findFirstNonWordChar(String text, int index){
        while(index < text.length()){
            if(String.valueOf(text.charAt(index)).matches("\\W")){
                break;
            }
        }
        return index;
    }
    
    //Metodo para dibujar las palabras reservadas
    private void colors(){
        final StyleContext cont = StyleContext.getDefaultStyleContext();
        
        //Colores 
        final AttributeSet attred = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(249, 249, 249));
        final AttributeSet attgreen = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(144, 56, 107));
        final AttributeSet attblue = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(144, 56, 107));
        final AttributeSet attblack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(0, 0, 0));
        final AttributeSet attpurple = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(144, 0, 144));
        
        //Estilo 
        DefaultStyledDocument doc = new DefaultStyledDocument(){
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException{
                super.insertString(offset, str, a);
                
                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if(before < 0){
                    before = 0;
                }
                int after = findFirstNonWordChar(text, offset+str.length());
                int wordL = before;
                int wordR = before;
                
                while(wordR <= after){//colocar palabras reservadas
                    if(wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")){
                        if(text.substring(wordL, wordR).matches("(\\W)*(program|if|else|fi|while|do|until|read|write|float|int|bool|not|and|or)")){
                            setCharacterAttributes(wordL, wordR - wordL, attblue, false);
                        }
                        else{
                            setCharacterAttributes(wordL, wordR - wordL, attblack, false);
                        }
                    wordL = wordR;
                    }
                    wordR++;
                }
            }
            //sobrecarga de metodo para ver en tiempo real la eliminacion de color, cuando no es una palabra reservada
            public void romeve(int offs, int len) throws BadLocationException{
                super.remove(offs, len);
                
                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offs);
                if(before < 0){
                    before = 0;
                }
            }
        };
        //mostrarlo en el panel
        JTextPane txt = new JTextPane(doc);
        String temp = txtResultado.getText();
        txtResultado.setStyledDocument(txt.getStyledDocument());
        txtResultado.setText(temp);
    }

    private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                /*case Comillas:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    break;
                case Cadena:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case T_dato:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;*/
                case Program:
                    resultado += "  <Reservada program>\t" + lexer.lexeme + "\n";
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexer.lexeme + "\n";
                    break;
                case Fi:
                    resultado += "  <Reservada fi>\t" + lexer.lexeme + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexer.lexeme + "\n";
                    break;
                case Until:
                    resultado += "  <Reservada until>\t" + lexer.lexeme + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case Read:
                    resultado += "  <Reservada read>\t" + lexer.lexeme + "\n";
                    break;
                case Write:
                    resultado += "  <Reservada write>\t" + lexer.lexeme + "\n";
                    break;
                case Float:
                    resultado += "  <Reservada float>\t" + lexer.lexeme + "\n";
                    break;
                case Int:
                    resultado += "  <Reservada int>\t" + lexer.lexeme + "\n";
                    break;
                case Bool:
                    resultado += "  <Reservada booleano>\t" + lexer.lexeme + "\n";
                    break;
                case Not:
                    resultado += "  <Reservada not>\t" + lexer.lexeme + "\n";
                    break;
                case And:
                    resultado += "  <Reservada and>\t" + lexer.lexeme + "\n";
                    break;
                case Or:
                    resultado += "  <Reservada or>\t" + lexer.lexeme + "\n";
                    break;
                case Then:
                    resultado += "  <Reservada then>\t" + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexer.lexeme + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    break;
                case Potencia:
                    resultado += "  <Operador potencia>\t" + lexer.lexeme + "\n";
                    break;
                case Menor:
                    resultado += "  <Operador menor>\t" + lexer.lexeme + "\n";
                    break;
                case Menor_igual:
                    resultado += "  <Operador menor_igual>\t" + lexer.lexeme + "\n";
                    break;
                case Mayor:
                    resultado += "  <Operador mayor>\t" + lexer.lexeme + "\n";
                    break;
                case Mayor_igual:
                    resultado += "  <Operador mayor_igual>\t" + lexer.lexeme + "\n";
                    break;
                case Asignacion:
                    resultado += "  <Operador asignacion>\t" + lexer.lexeme + "\n";
                    break;
                case Diferente:
                    resultado += "  <Operador diferente>\t" + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                    break;
                case Punto_coma:
                    resultado += "  <Operador punto_coma>\t" + lexer.lexeme + "\n";
                    break;
                case Coma:
                    resultado += "  <Operador coma>\t" + lexer.lexeme + "\n";
                    break;
                case Punto:
                    resultado += "  <Operador punto>\t" + lexer.lexeme + "\n";
                    break;
                /*case Op_logico:
                    resultado += "  <Operador logico>\t" + lexer.lexeme + "\n";
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexer.lexeme + "\n";
                    break;
                case Op_relacional:
                    resultado += "  <Operador relacional>\t" + lexer.lexeme + "\n";
                    break;*/
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexer.lexeme + "\n";
                    break;
                case Par_abre:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Par_cierre:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_abre:
                    resultado += "  <Llave de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_cierre:
                    resultado += "  <Llave de cierre>\t" + lexer.lexeme + "\n";
                    break;
                /*case Corchete_a:
                    resultado += "  <Corchete de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t" + lexer.lexeme + "\n";
                    break;*/
                case Main:
                    resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case Decimal:
                    resultado += "  <Decimal>\t\t" + lexer.lexeme + "\n";
                    break;
                case Error:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        brnReservadas = new javax.swing.JButton();
        btnIdent = new javax.swing.JButton();
        btnTokens = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnAnalizarLex = new javax.swing.JButton();
        btnAnalizarSin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/guardar_icon.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/nuevo_icon.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/abrir_icon.png"))); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        brnReservadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/reservadas_icon.png"))); // NOI18N
        brnReservadas.setText("Reservadas");
        brnReservadas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        brnReservadas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        brnReservadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnReservadasActionPerformed(evt);
            }
        });
        getContentPane().add(brnReservadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        btnIdent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/ident_icon.png"))); // NOI18N
        btnIdent.setText("Ident");
        btnIdent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIdent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIdent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdentActionPerformed(evt);
            }
        });
        getContentPane().add(btnIdent, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        btnTokens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/tokens_icon.png"))); // NOI18N
        btnTokens.setText("Tokens");
        btnTokens.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTokens.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnTokens, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/icons/compilar_icon.png"))); // NOI18N
        btnCompilar.setText("Compilar");
        btnCompilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCompilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        txtResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtResultadoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtResultado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 750, 370));

        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarSin);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 526, 1240, 170));

        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarLex);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 470, 370));

        btnAnalizarLex.setText("Analizar Lexico");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnalizarLex, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, -1, -1));

        btnAnalizarSin.setText("Analizar Sintactico");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnalizarSin, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        dir.Guardar(this);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        txtAnalizarLex.setText("");
        txtAnalizarSin.setText("");
        dir.Nuevo(this);
        clearAllComp();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        // TODO add your handling code here:
        //dir.Abrir(this);
        //clearAllComp();
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        try{
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no encontrado");
        } catch (IOException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void brnReservadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnReservadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brnReservadasActionPerformed

    private void btnIdentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIdentActionPerformed

    private void txtResultadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtResultadoKeyReleased
        // TODO add your handling code here:
        int keyCode = evt.getKeyCode();
        if((keyCode >= 65 && keyCode <= 90) || (keyCode >= 48 && keyCode <=57)
                || (keyCode >= 97 && keyCode <= 122) || (keyCode != 27 && (keyCode >= 37
                && keyCode <= 40) && !(keyCode >= 16
                && keyCode <= 18) && keyCode != 524
                && keyCode != 20)){
            if(!getTitle().contains("*")){
                setTitle(getTitle() + "*");
            }
        }
    }//GEN-LAST:event_txtResultadoKeyReleased

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        // TODO add your handling code here:
        /*File archivo = new File("archivo.txt");
        PrintWriter escribir;
        try{
            escribir = new PrintWriter(archivo);
            escribir.print(txtResultado.getText());
            escribir.close();
        }catch(FileNotFoundException ex){
            System.out.println("Error escribir archivo.txt" + ex);
        }
        try{
            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            while(true){
                Tokens tokens = lexer.yylex();
                if(tokens ==null){
                    resultado +="FIN";
                    txtAnalizarLex.setText(resultado);
                    return;
                }
                switch (tokens) {
                    case Error:
                        resultado += "Simbolo no definido\n";
                        break;
                    case Identificador: case Numero: case Decimal:
                        resultado += lexer.lexeme + ": Es un " + tokens + "\n";
                        break;
                    default:
                        resultado += "Token: " + tokens + "\n";
                        break;
                }
            }
        }catch(FileNotFoundException ex){
            System.out.println("Error leer archivo.txt" + ex);
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        // TODO add your handling code here:
        try{        
            analizarLexico();
        } catch (IOException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        // TODO add your handling code here:
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new compiler.LexerCup(new StringReader(ST)));

        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realizado OK");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex){
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

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
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IDE().setVisible(true);
            }
        });
    }
    
    private void inicializar(){
        dir = new Directorio();
        
        setTitle("IDE");
        String[] options = new String[]{"Guardar y continuar", "Descargar"};
        
        numeroLinea = new NumeroLinea(txtResultado);
        jScrollPane1.setRowHeaderView(numeroLinea);
    }
    
    public void clearAllComp(){
        txtAnalizarSin.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnReservadas;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIdent;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnTokens;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    public javax.swing.JTextPane txtResultado;
    // End of variables declaration//GEN-END:variables
}
