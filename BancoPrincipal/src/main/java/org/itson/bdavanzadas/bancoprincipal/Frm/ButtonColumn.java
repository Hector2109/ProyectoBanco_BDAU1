package org.itson.bdavanzadas.bancoprincipal.Frm;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 * Clase que implementa una columna de botones para ser utilizada en un JTable.
 * Esta clase proporciona tanto un renderizador como un editor de celdas para mostrar
 * y manejar botones en una columna de una tabla.
 */
public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

    private final JButton renderButton; // Botón utilizado para renderizar la celda
    private final JButton editButton;   // Botón utilizado para editar la celda
    private Object currentValue;        // Valor actual de la celda

    /**
     * Constructor de la clase ButtonColumn.
     * 
     * @param buttonText     Texto a mostrar en los botones.
     * @param actionListener Objeto ActionListener que maneja los eventos de los botones.
     */
    public ButtonColumn(String buttonText, ActionListener actionListener) {
        // Inicialización de los botones de renderizado y edición
        renderButton = new JButton(buttonText);
        renderButton.setFocusPainted(false);

        editButton = new JButton(buttonText);
        editButton.setFocusPainted(false);
        editButton.addActionListener(actionListener);
    }

    /**
     * Método de la interfaz TableCellRenderer.
     * Retorna el componente (botón) utilizado para renderizar la celda.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Configuración de la apariencia del botón dependiendo del estado de la celda
        if (hasFocus) {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(table.getBackground());
        } else if (isSelected) {
            renderButton.setForeground(table.getSelectionForeground());
            renderButton.setBackground(table.getSelectionBackground());
        } else {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(table.getBackground());
        }

        // Establecimiento del texto del botón según el valor de la celda
        renderButton.setText((value == null) ? "" : value.toString());
        return renderButton;
    }

    /**
     * Método de la interfaz TableCellEditor.
     * Retorna el componente (botón) utilizado para editar la celda.
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // Almacenamiento del valor actual de la celda
        currentValue = value;
        // Establecimiento del texto del botón según el valor de la celda
        editButton.setText((value == null) ? "" : value.toString());
        return editButton;
    }

    /**
     * Método de la interfaz TableCellEditor.
     * Retorna el valor de la celda editada.
     */
    @Override
    public Object getCellEditorValue() {
        return currentValue;
    }

    /**
     * Método para establecer el texto de los botones de renderizado y edición.
     * 
     * @param text Texto a establecer en los botones.
     */
    public void setButtonText(String text) {
        renderButton.setText(text);
        editButton.setText(text);
    }
}
