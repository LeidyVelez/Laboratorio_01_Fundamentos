<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Presentacion.xsl
    Created on : 23 de mayo de 2014, 12:08 PM
    Author     : Leidy
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">

   <html>
   <head>
      <title>Biblioteca</title>
   </head>
   <xsl:apply-templates select="library" />
   </html>

</xsl:template>


<xsl:template match="library">
	
   <body bgcolor="#fafafa">

   <h2 align="center">Mis libros</h2>

   <table align="center" border="2">
     <tr bgcolor="#ccffff">
       <th>Titulo</th>
       <th>Autor</th>
       <th>ISBN</th>
       <th>Año de publicación</th>
     </tr>
		
     <xsl:for-each select="book">
     <xsl:sort select="title[@language='es']" order="ascending" />
         
     <tr>
       <td valign="top">
         <b><xsl:value-of select="title[@language='es']"/></b>
         <br/> 
         (<font color="0000cc"><xsl:value-of select="title"/></font>)
       </td>
       <td valign="top">
         <font color="700000"><xsl:value-of select="author"/></font>
       </td>
 
       <td valign="top">
         <font size="-1">
         <xsl:for-each select="edition">      
            <xsl:value-of select="isbn" />
            <br />
         </xsl:for-each>
         </font>
       </td>
       
        <td valign="top">
         <font size="-1">
         <xsl:for-each select="edition">      
            <xsl:value-of select="year" />
            <br />
         </xsl:for-each>
         </font>
       </td>
       
     </tr>

     </xsl:for-each>
		
   </table>
   </body>
	
</xsl:template>

</xsl:stylesheet>
