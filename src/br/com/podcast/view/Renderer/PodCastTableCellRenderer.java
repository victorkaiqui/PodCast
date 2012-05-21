/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.view.Renderer;

import br.com.podcast.reader.PodCast;
import br.com.podcast.view.model.PodCastTableModel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author vpaz
 */
public class PodCastTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        PodCast podcast = ((PodCastTableModel) table.getModel()).getPodCast(row);
        if (podcast.getDownloadConcluido()) {
            c.setForeground(new Color(0, 150, 0));
        } else if (podcast.isNovoPodCast()) {
            c.setForeground(new Color(0, 0, 150));
        } else {
            c.setForeground(Color.black);
        }


        return c;
    }
}
