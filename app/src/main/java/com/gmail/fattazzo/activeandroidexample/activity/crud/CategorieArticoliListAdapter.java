package com.gmail.fattazzo.activeandroidexample.activity.crud;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.gmail.fattazzo.activeandroidexample.db.models.Articolo;
import com.gmail.fattazzo.activeandroidexample.db.models.Categoria;

import java.util.List;
import java.util.Map;

public class CategorieArticoliListAdapter extends BaseExpandableListAdapter {

    private Context _context;

    private List<Categoria> _listDataHeader;
    private Map<Categoria, List<Articolo>> _listDataChild;

    public CategorieArticoliListAdapter(Context context, List<Categoria> listDataHeader,
                                        Map<Categoria, List<Articolo>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Articolo getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final Articolo articolo = getChild(groupPosition, childPosition);

        ArticoloListItemView articoloListItemView;
        if (convertView == null) {
            articoloListItemView = ArticoloListItemView_.build(_context);
        } else {
            articoloListItemView = (ArticoloListItemView) convertView;
        }

        articoloListItemView.bind(articolo);
        return articoloListItemView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Categoria getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        Categoria categoria = getGroup(groupPosition);

        CategoriaListItemView categoriaListItemView;
        if (convertView == null) {
            categoriaListItemView = CategoriaListItemView_.build(_context);
        } else {
            categoriaListItemView = (CategoriaListItemView) convertView;
        }

        categoriaListItemView.bind(categoria);
        return categoriaListItemView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}