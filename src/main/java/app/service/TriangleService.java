package app.service;

import app.domain.Triangle;

import java.math.BigDecimal;

public interface TriangleService {
    Triangle getTriangleType(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC);
}
