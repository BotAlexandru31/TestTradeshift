package triangletest;

import java.io.Serializable;

public class Triangle implements Serializable{
	//base class
	//contains core private members and public setters and getters.
	//serializable class -useful at a higher level programming (JEE) when sending objects between different systems
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Triangle() {

	}
 
	private Double cathetus1;
	private Double cathetus2;
	private	Double hypotenuse;

	public Triangle(Double cat1, Double cat2, Double hyp) {
		this.cathetus1 = cat1;
		this.cathetus2 = cat2;
		this.hypotenuse = hyp;
	}

	public Double getCathetus1() {
		return cathetus1;
	}

	public void setCathetus1(Double cathetus1) {
		this.cathetus1 = cathetus1;
	}

	public Double getCathetus2() {
		return cathetus2;
	}

	public void setCathetus2(Double cathetus2) {
		this.cathetus2 = cathetus2;
	}

	public Double getHypotenuse() {
		return hypotenuse;
	}

	public void setHypotenuse(Double hypotenuse) {
		this.hypotenuse = hypotenuse;
	}

	@Override
	public String toString() {
		return "Triangle [cathetus1=" + cathetus1 + ", cathetus2=" + cathetus2 + ", hypotenuse=" + hypotenuse + "]";
	}


}
