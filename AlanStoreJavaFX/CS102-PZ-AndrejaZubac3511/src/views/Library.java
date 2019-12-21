/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.TilePane;

/**
 *
 * @author andre
 */
public class Library extends ScrollPane{
    
    public TilePane libraryTilePane;

    public Library() {

        libraryTilePane = new TilePane();

        setFitToWidth(true);
        setPrefHeight(400.0);
        setPrefWidth(500.0);

        libraryTilePane.setHgap(8.0);
        libraryTilePane.setMaxHeight(Double.MAX_VALUE);
        libraryTilePane.setMaxWidth(Double.MAX_VALUE);
        libraryTilePane.setMinHeight(USE_PREF_SIZE);
        libraryTilePane.setMinWidth(USE_PREF_SIZE);
        libraryTilePane.setPrefHeight(400.0);
        libraryTilePane.setPrefWidth(500.0);
        libraryTilePane.getStylesheets().add("/views/style.css");
        libraryTilePane.setTileAlignment(javafx.geometry.Pos.TOP_LEFT);
        libraryTilePane.setVgap(8.0);
        libraryTilePane.setPadding(new Insets(8.0));
        setContent(libraryTilePane);
        setPadding(new Insets(8.0));

    }
    
}
