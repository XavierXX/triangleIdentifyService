package app.service.imp;

import app.domain.Triangle;
import app.service.TriangleService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TriangleServiceImp implements TriangleService {
    @Override
    public Triangle getTriangleType(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) {
        Triangle t = new Triangle(sideA, sideB, sideC);
        // check if this is valid
        if (isTriangle(sideA, sideB, sideC)) {

            // check if all 3 sides equal
            if (sideA.compareTo(sideB) == 0
                    && sideB.compareTo(sideC) == 0) {
                t.setTriangleType("Equilateral triangle");
                // check if any two size equal;
            } else if (sideA.compareTo(sideB) == 0
                    || sideB.compareTo(sideC) == 0
                    || sideC.compareTo(sideA) == 0) {
                t.setTriangleType("Isosceles triangle");

            } else {
                t.setTriangleType("Scalene Triangle");
            }
            return t;
        } else {
            t.setTriangleType("invalid");
            return t;
        }
    }

    public boolean isTriangle(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) {
        if (validateSide(sideA)
                && validateSide(sideB)
                && validateSide(sideC)) {
            return sideA.add(sideB).compareTo(sideC) > 0
                    || sideB.add(sideC).compareTo(sideA) > 0
                    || sideC.add(sideA).compareTo(sideB) > 0;
        } else {
            return false;
        }

    }

    private boolean validateSide(BigDecimal side) {
        return (side != null) && (side.compareTo(BigDecimal.ZERO) > 0);
    }
}
