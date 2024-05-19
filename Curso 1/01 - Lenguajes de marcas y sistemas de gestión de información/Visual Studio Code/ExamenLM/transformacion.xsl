<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8"/>
    <xsl:template match="/">
        <style>
            /* Estilos de tabla */
            table {
            text-align: center;
            border: 1px solid black;
            }
            
            th, caption {
            background-color: cadetblue;
            color: white;
            padding: 0.3em;
            }
            
            caption {
                font-size:2em;
                margin-bottom:1em;
            }

            tr {
            padding: 0em;
            margin: 0px;
            }
            td {
            border: 1px solid black;
            }
        </style>
        <table>
            <caption>CFGS Informática</caption>
            <tr>
                <th>Horario</th>
                <th>Nombre</th>
                <th>Nivel</th>
            </tr>
            <xsl:for-each select="//ciclo">
                <xsl:if test="@horario = 'Diurno'">
                    <tr class="ciclo">
                        <td><xsl:value-of select="@horario"/></td>
                        <td><xsl:value-of select="nombre"/></td>
                        <td><xsl:value-of select="grado"/></td>
                    </tr>
                </xsl:if>
            </xsl:for-each>
        </table>
    </xsl:template>
    
</xsl:stylesheet>