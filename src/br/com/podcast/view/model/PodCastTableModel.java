/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podcast.view.model;

import br.com.podcast.reader.PodCast;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vpaz
 */
public class PodCastTableModel extends AbstractTableModel {

    private List<PodCast> podCastsList;

    public PodCastTableModel() {
        podCastsList = new ArrayList<PodCast>();
    }

    public int getRowCount() {
        return podCastsList.size();
    }

    public int getColumnCount() {
        return 2;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return podCastsList.get(rowIndex).getTitle();
            case 1:
                return podCastsList.get(rowIndex).getSelecionadoParaDownload();

            default:
                return "Fudeu";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex == 1) ? true : false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Boolean.class;
            default:
                return String.class;
        }
    }

    public PodCast getPodCast(int row) {

        return podCastsList.get(row);
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "Titulo";
            case 1:
                return "Selecionar";
            default:
                return "";
        }

    }

    public List<PodCast> getPodCastsList() {
        return podCastsList;
    }

    public void setPodCastsList(List<PodCast> podCastsList) {

        fireTableDataChanged();
        this.podCastsList = podCastsList;

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                podCastsList.get(rowIndex).setTitle((String) aValue);
                break;
            case 1:
                podCastsList.get(rowIndex).setSelecionadoParaDownload((Boolean) aValue);
                break;

        }

    }
}
