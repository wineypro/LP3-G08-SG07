/**
 * 
 */
/**
 * 
 */
module ExamenLp {
	  requires java.sql;

	    // permite que Swing y el launcher encuentren tus clases
	    requires java.desktop;

	    // exporta tus paquetes (al menos la vista para el Main y lo que use)
	    exports examenlp3.vista;
	    exports examenlp3.controlador;
	    exports examenlp3.modelo;
}
