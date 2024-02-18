package org.itson.bdavanzadas.bancoprincipal.Frm;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

    private final JButton renderButton;
    private final JButton editButton;
    private Object currentValue;

    public ButtonColumn(String buttonText, ActionListener actionListener) {
        renderButton = new JButton(buttonText);
        renderButton.setFocusPainted(false);

        editButton = new JButton(buttonText);
        editButton.setFocusPainted(false);
        editButton.addActionListener(actionListener);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
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

        renderButton.setText((value == null) ? "" : value.toString());
        return renderButton;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        currentValue = value;
        editButton.setText((value == null) ? "" : value.toString());
        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        return currentValue;
    }

    // Método para establecer el texto del botón
    public void setButtonText(String text) {
        renderButton.setText(text);
        editButton.setText(text);
    }
}