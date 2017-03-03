package org.rlopez.GUI.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Richard Lopez
 */
public class VoilierTableModel extends AbstractTableModel {

    private final String[] entetes = {"Nom", "Numéro", "Propriétaire", "Classe"};
    private List<Voilier> voiliers;

    public VoilierTableModel(List<Voilier> voiliers) {
        this.voiliers = voiliers;
    }

    public void setModel(List<Voilier> voiliers) {
        this.voiliers = voiliers;
        fireTableDataChanged();
    }

    public void addVoilier(Voilier voilier) {
        this.voiliers.add(voilier);
        this.fireTableDataChanged();
    }

    public void delStagiaire(Voilier voilier) {
        this.voiliers.remove(voilier);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return entetes[column];
    }

    @Override
    public int getRowCount() {
        return voiliers.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    public Voilier getVoilier(int rowIndex) {
        return voiliers.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return voiliers.get(rowIndex).getNom_voilier();

            case 1:
                return voiliers.get(rowIndex).getNum_voile();

            case 2:
                return voiliers.get(rowIndex).getProprietaire().getPrenom_personne() + " " + voiliers.get(rowIndex).getProprietaire().getNom_personne();

            case 3:
                return voiliers.get(rowIndex).getClasse().getNom_classe();

            default:
                throw new IllegalArgumentException();
        }

    }

}
