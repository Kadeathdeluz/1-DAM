<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8"/>
    <xsl:template match="/">
        
        <!-- APARTADO A: Nombres sin etiquetas -->
        <xsl:text>Apartado A: </xsl:text>
        <xsl:for-each select="//ciclo">
            <xsl:value-of select="nombre"/>
            <br/>
        </xsl:for-each>
        <br/>
        
        <!-- APARTADO B: Nombres en párrafos -->
        <xsl:text>Apartado B: </xsl:text>
        <xsl:for-each select="//ciclo">
            <p><xsl:value-of select="nombre"/></p>
        </xsl:for-each>
        
        <!-- APARTADO C: Lista sin numerar de nombres y (grados) -->
        <xsl:text>Apartado C: </xsl:text>
        <ul>
            <xsl:for-each select="//ciclo">
                <li><xsl:value-of select="nombre"/>
                    <xsl:text> (</xsl:text>
                    <xsl:value-of select="grado"/>
                    <xsl:text>)</xsl:text>
                </li>
            </xsl:for-each>
        </ul>
        
        <!-- APARTADO D: Lista numerada -->
        <xsl:text>Apartado D: </xsl:text>
        <ol>
            <xsl:for-each select="//ciclo">
            <xsl:sort select="nombre" order="descending"/>
                <li><xsl:value-of select="nombre"/>
                    <xsl:text> (</xsl:text>
                    <xsl:value-of select="grado"/>
                    <xsl:text>)</xsl:text>
                </li>
            </xsl:for-each>
        </ol>

    </xsl:template>
</xsl:stylesheet>