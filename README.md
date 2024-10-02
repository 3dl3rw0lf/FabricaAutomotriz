* [ ] ## Package Main

* [ ] Sólo debe contener la clase principal de la aplicación.

* [ ] ## Package Almacen

	* [ ] ### Inventario (una instancia por cada marca de auto)
	
		atributos:
	
		* [ ] marca: cadena con el nombre
	
		métodos:
	
		- [ ] agregar: crea un nuevo vehículo
		- [ ] listar: utiliza el objeto Impresora, para
		- [ ] mostrar todo el inventario.

	* [ ] ### Componente (es abstracta)

	* [ ] ### Motor y Carroceria (sus atributos son constantes de acceso público y no implementan métodos)

* [ ] la cardinalidad 1..n implementarla con un contenedor ArrayList
## Package Dispositivos
* [ ]  ### Impresora (se simula con la salida por pantalla)

## Interface visual

* [ ] Crear una interface visual para el modelo, con los siguientes componentes visuales:

	* [ ] Área de Texto, donde se muestren las salidas de la aplicación.
	* [ ] Un campo de texto por cada valor de atributo que sea necesario inicializar al crear un objeto (inicialmente están todos inhabilitados).
	* [ ] Conjunto de botones radiales, uno por cada clase de objeto que es posible crear, cuando se activa uno de ellos, se habilita la escritura en los campos de textos que correspondan.
  * [ ] Lista de Selección, donde se agrega un ítem para referenciar cada objeto creado.
  * [ ] Botón, para crear un objeto de la clase según el botón radial marcado, inicializándolo con los valores que figuren en los respectivos campos de texto habilitados y luego borre el contenido de los campos de texto y los inhabilite. Se genera la nueva entrada en la lista de selección. 
  * [ ] Botón, para mostrar en área de texto el valor de los atributos del objeto señalado en la lista de selección.
  
* [ ] Implementar la serialización de los objetos para el modelo, efectuando el almacenamiento/recuperación en archivos planos de texto.