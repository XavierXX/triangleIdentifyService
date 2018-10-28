package app.domain;

import java.math.BigDecimal;

public class Triangle {
    BigDecimal sideA;
    BigDecimal sideB;
    BigDecimal sideC;
    String triangleType;

    public Triangle(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public BigDecimal getSideA() {
        return sideA;
    }

    public void setSideA(BigDecimal sideA) {
        this.sideA = sideA;
    }

    public BigDecimal getSideB() {
        return sideB;
    }

    public void setSideB(BigDecimal sideB) {
        this.sideB = sideB;
    }

    public BigDecimal getSideC() {
        return sideC;
    }

    public void setSideC(BigDecimal sideC) {
        this.sideC = sideC;
    }

    public String getTriangleType() {
        return triangleType;
    }

    public void setTriangleType(String triangleType) {
        this.triangleType = triangleType;
    }
}
