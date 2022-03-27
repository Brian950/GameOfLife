package com.ohme.domain.universe.base;

import com.ohme.domain.cell.base.Cell;

public abstract class Universe {

    protected int dimension;

    // Using a boolean[][] array will default all values to false
    protected Cell[][] universe;

    protected abstract void buildUniverse(int dimension);

    public Cell[][] getUniverse() {
        return universe;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Cell[] row : universe) {
            for(Cell col : row) {
                builder.append("[");
                if(col.isAlive()) builder.append("x");
                else builder.append(" ");
                builder.append("]");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public String toHtmlString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<table style='border: 1px solid black;'>");
        for(Cell[] row : universe) {
            builder.append("<tr>");
            for(Cell col : row) {
                builder.append("<td style='border: 1px solid black; " +
                        "border-collapse: collapse; height: 20px; width: 20px; text-align: center; '>");
                if(col.isAlive()) builder.append("<p>x</p>");
                else builder.append("<p>-</p>");
                builder.append("</td>");
            }
            builder.append("</tr>");
        }
        builder.append("</table>");
        return builder.toString();
    }

}
