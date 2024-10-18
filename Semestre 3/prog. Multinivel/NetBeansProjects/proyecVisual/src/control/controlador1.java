package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.EntradaDatos;
import vista.Ventana1;


public class controlador1 implements ActionListener{
  private final Ventana1 objV1;
  private final EntradaDatos ent;
  private int correcto,continuar;

    public controlador1() {
        this.correcto = 0;
        this.objV1 = new Ventana1();
        this.ent = new EntradaDatos();
        ent.setTitulo("¿Quién quiere ser millonario?");
        objV1.getRespuestas().add(objV1.getRbresp1());
        objV1.getRespuestas().add(objV1.getRbresp2());
        objV1.getRespuestas().add(objV1.getRbresp3());
        objV1.getRespuestas().add(objV1.getRbresp4());
        objV1.getRbresp1().addActionListener(this);
        objV1.getRbresp2().addActionListener(this);
        objV1.getRbresp3().addActionListener(this);
        objV1.getRbresp4().addActionListener(this);
        objV1.getTxtPregunta().setText("¿Cuál es el nombre del fundador del taekwondo moderno?");
        objV1.getRbresp1().setText("a. Kim Jon .un");
        objV1.getRbresp2().setText("b. Choi Hong Hi");
        objV1.getRbresp3().setText("c. Bruce Lee");
        objV1.getRbresp4().setText("d. Jackie Chan");
        objV1.getOpciones().setText("Opciones.");
    }
  public void iniciar()
  {
      objV1.setTitle("Juego");
      objV1.setVisible(true);
      objV1.setLocationRelativeTo(null);
  }

    /**
     *
     * @param e
     */
 @Override
public void actionPerformed(ActionEvent e) {
        switch (objV1.getTxtPregunta().getText()) {
              case "¿Cuál es el nombre del fundador del taekwondo moderno?" -> {
                  if (e.getSource() == objV1.getRbresp2()) {
                      ent.mostrar("Respuesta correcta, ¡Felicidades!");
                      correcto = correcto + 1;
                  } else {
                      ent.mostrar("Respuesta incorrecta");
                  }
              }
              case "¿En qué país se originó el taekwondo?" -> {
                  if (e.getSource() == objV1.getRbresp3()) {
                      ent.mostrar("Respuesta correcta, ¡Felicidades!");
                      correcto = correcto + 1;
                  } else {
                      ent.mostrar("Respuesta incorrecta");
                  }
              }
              case "¿Qué significa \"tae\" en taekwondo?" -> {
                  if (e.getSource() == objV1.getRbresp2()) {
                      ent.mostrar("Respuesta correcta, ¡Felicidades!");
                      correcto = correcto + 1;
                  } else {
                      ent.mostrar("Respuesta incorrecta");
                  }
              }
              case "¿Cuál es el nombre del saludo utilizado en taekwondo?" -> {
                  if (e.getSource() == objV1.getRbresp3()) {
                      ent.mostrar("Respuesta correcta, ¡Felicidades!");
                      correcto = correcto + 1;
                  } else {
                      ent.mostrar("Respuesta incorrecta");
                  }
              }
              case "¿Quién es considerado el padre del taekwondo en Corea del Sur?" -> {
                  if (e.getSource() == objV1.getRbresp3()) {
                      ent.mostrar("Respuesta correcta, ¡Felicidades!");
                      correcto = correcto + 1;
                  } else {
                      ent.mostrar("Respuesta incorrecta");
                  }
              }
              case "¿Cuántos grados de cinturón hay en taekwondo?" -> {
                  if (e.getSource() == objV1.getRbresp2()) {
                      ent.mostrar("Respuesta correcta, ¡Felicidades!");
                      correcto = correcto + 1;
                  } else {
                      ent.mostrar("Respuesta incorrecta");
                  }
              }
              case "¿Cuál es la forma básica en taekwondo que significa \"paz y serenidad\"?" -> {
                  if (e.getSource() == objV1.getRbresp1()) {
                      ent.mostrar("Respuesta correcta, ¡Felicidades!");
                      correcto = correcto + 1;
                  } else {
                      ent.mostrar("Respuesta incorrecta");
                  }
              }
              case "¿Cuál es el nombre del golpe más básico en taekwondo, que se ejecuta con el pie?" -> {
                  if (e.getSource() == objV1.getRbresp3()) {
                      ent.mostrar("Respuesta correcta, ¡Felicidades!");
                      correcto = correcto + 1;
                  } else {
                      ent.mostrar("Respuesta incorrecta");
                  }
                  JOptionPane.showMessageDialog(objV1, "Tu puntaje fue: " + correcto, "Puntaje final", JOptionPane.INFORMATION_MESSAGE);
                  continuar = JOptionPane.showConfirmDialog(objV1, "¿Desea volver a jugar? ", "Aviso", JOptionPane.YES_NO_OPTION);
              }
              default -> {
              }
          }



        // Limpiar la selección de los botones de radio
        objV1.getRespuestas().clearSelection();

        // Desactivar el ActionListener para las opciones anteriores
        objV1.getRbresp1().removeActionListener(this);
        objV1.getRbresp2().removeActionListener(this);
        objV1.getRbresp3().removeActionListener(this);
        objV1.getRbresp4().removeActionListener(this);

          // Configurar la nueva pregunta y opciones
          switch (objV1.getTxtPregunta().getText()) {
              case "¿Cuál es el nombre del fundador del taekwondo moderno?" -> {
                  objV1.getTxtPregunta().setText("¿En qué país se originó el taekwondo?");
                  objV1.getRbresp1().setText("a) Japón");
                  objV1.getRbresp2().setText("b) China");
                  objV1.getRbresp3().setText("c) Corea del sur");
                  objV1.getRbresp4().setText("d) Tailandia");
              }
              case "¿En qué país se originó el taekwondo?" -> {
                  objV1.getTxtPregunta().setText("¿Qué significa \"tae\" en taekwondo?");
                  objV1.getRbresp1().setText("a) Mano");
                  objV1.getRbresp2().setText("b) Patada");
                  objV1.getRbresp3().setText("c) Cabeza");
                  objV1.getRbresp4().setText("d) Rodilla");
              }
              case "¿Qué significa \"tae\" en taekwondo?" -> {
                  objV1.getTxtPregunta().setText("¿Cuál es el nombre del saludo utilizado en taekwondo?");
                  objV1.getRbresp1().setText("a) Hola");
                  objV1.getRbresp2().setText("b) Namaste");
                  objV1.getRbresp3().setText("c) Annyeonghaseyo");
                  objV1.getRbresp4().setText("d) Kukkiwon ");
              }
              case "¿Cuál es el nombre del saludo utilizado en taekwondo?" -> {
                  objV1.getTxtPregunta().setText("¿Cuántos grados de cinturón hay en taekwondo?");
                  objV1.getRbresp1().setText("a) 5");
                  objV1.getRbresp2().setText("b) 7");
                  objV1.getRbresp3().setText("c) 9");
                  objV1.getRbresp4().setText("d) 11");
              }
              case "¿Cuántos grados de cinturón hay en taekwondo?" -> {
                  objV1.getTxtPregunta().setText("¿Quién es considerado el padre del taekwondo en Corea del Sur?");
                  objV1.getRbresp1().setText("a) Kim Jon- il");
                  objV1.getRbresp2().setText("b) Park Geun - hye");
                  objV1.getRbresp3().setText("c) Choi Hong lee");
                  objV1.getRbresp4().setText("d) Ban Ki-Moon");
              }
              case "¿Quién es considerado el padre del taekwondo en Corea del Sur?" -> {
                  objV1.getTxtPregunta().setText("¿Cuál es la forma básica en taekwondo que significa \"paz y serenidad\"?");
                  objV1.getRbresp1().setText("a) Taeguk Il Jang");
                  objV1.getRbresp2().setText("b) Pyongwon");
                  objV1.getRbresp3().setText("c) Sipjin");
                  objV1.getRbresp4().setText("d) Koryo");
              }
              case "¿Cuál es la forma básica en taekwondo que significa \"paz y serenidad\"?" -> {
                  objV1.getTxtPregunta().setText("¿Cuál es el nombre del golpe más básico en taekwondo, que se ejecuta con el pie?");
                  objV1.getRbresp1().setText("a) Puño");
                  objV1.getRbresp2().setText("b) Mano");
                  objV1.getRbresp3().setText("c) Patada");
                  objV1.getRbresp4().setText("d) Codo");
              }

              default -> {
              }
          }

          if (continuar == JOptionPane.YES_OPTION) {
                      correcto = 0;
                      objV1.getRespuestas().clearSelection();
                      objV1.getRbresp1().removeActionListener(this);
                      objV1.getRbresp2().removeActionListener(this);
                      objV1.getRbresp3().removeActionListener(this);
                      objV1.getRbresp4().removeActionListener(this);
                      objV1.getTxtPregunta().setText("¿Cuál es el nombre del fundador del taekwondo moderno?");
                      objV1.getRbresp1().setText("a. Kim Jon .un");
                      objV1.getRbresp2().setText("b. Choi Hong Hi");
                      objV1.getRbresp3().setText("c. Bruce Lee");
                      objV1.getRbresp4().setText("d. Jackie Chan");
                      objV1.getOpciones().setText("Opciones.");
          }         
          
        // Activar el ActionListener para las opciones de la nueva pregunta
        objV1.getRbresp1().addActionListener(this);
        objV1.getRbresp2().addActionListener(this);
        objV1.getRbresp3().addActionListener(this);
        objV1.getRbresp4().addActionListener(this);
        
    }
}
