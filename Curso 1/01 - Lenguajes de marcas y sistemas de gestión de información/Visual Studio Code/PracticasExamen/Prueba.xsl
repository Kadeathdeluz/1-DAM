<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8"/>
    <!-- Crea una lista ordenada que contiene cada uno de los ciclos y los ordena por año (ASC) -->
    <xsl:template match="/">
        <style>
            table {
            border: 1px solid black;
            }
            
            th, tr, td {
            border: 1px solid black;
            padding: 1em;
            }
        </style>
        <table>
            <tbody>
                <tr class="titulos">
                    <th>Nombre</th>
                    <th>Siglas</th>
                    <th>Grado</th>
                    <th>Año</th>
                </tr>
                <!-- Cada vez que encuentra una elemento ciclo, activa el template -->
                <xsl:apply-templates select="//ciclos">
                </xsl:apply-templates>
            </tbody>
        </table>
        <p>------------------------ Ahora sólo los superiores --------------------------------- </p>
        <table>
            <tbody>
                <tr class="titulos">
                    <th>Nombre</th>
                    <th>Siglas</th>
                    <th>Grado</th>
                    <th>Año</th>
                </tr>
                <!-- Para cada ciclo (for-each) -->
                <xsl:for-each select="//ciclo[grado = 'Superior']">
                    
                    <tr class="ciclo">
                        <td><xsl:value-of select="nombre"/></td>
                        <td><xsl:value-of select="@id"/></td>
                        <td><xsl:value-of select="grado"/></td>
                        <td>
                            <xsl:choose>
                                <xsl:when test="decretoTitulo/@año &gt; 2009">
                                    <font color="red"><xsl:value-of select="decretoTitulo/@año"/></font>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:value-of select="decretoTitulo/@año"/>
                                </xsl:otherwise>
                            </xsl:choose>
                            
                        </td>
                    </tr>
                </xsl:for-each>
            </tbody>
        </table>
        
    </xsl:template>
    
    <!-- Template para mostrar los ciclos en una tabla -->
    <xsl:template match="ciclos">
        <xsl:for-each select="ciclo">
            <xsl:sort select="decretoTitulo/@año" order="descending"/>
            <tr class="ciclo">
                <td><xsl:value-of select="nombre"/></td>
                <td><xsl:value-of select="@id"/></td>
                <td><xsl:value-of select="grado"/></td>
                <td><xsl:value-of select="decretoTitulo/@año"/></td>
            </tr>
        </xsl:for-each>
        
        
    </xsl:template>
    
</xsl:stylesheet>