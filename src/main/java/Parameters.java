/**
 * Defined parameters as given by assignment paper. These values are given in input
 * and used in most calculations. They are constants and unchangeable.
 * @param length1
 * @param length2
 * @param radius1
 * @param radius2
 * @param area1
 * @param area2
 * @param epsilon
 * @param distance
 * @param quads
 * @param qPoints
 * @param nPoints
 * @param kPoints
 * @param aPoints
 * @param bPoints
 * @param cPoints
 * @param dPoints
 * @param ePoints
 * @param fPoints
 * @param gPoints
 */
public record Parameters(
    double length1,
    double length2,
    double radius1,
    double radius2,
    double area1,
    double area2,
    double epsilon,
    double distance,
    int quads,
    int qPoints,
    int nPoints,
    int kPoints,
    int aPoints,
    int bPoints,
    int cPoints,
    int dPoints,
    int ePoints,
    int fPoints,
    int gPoints
) {
    /**
     * Constructor with validation based on the limitations given in assignment paper.
     */
    public Parameters {
        if (length1 < 0 || length2 < 0)
            throw new IllegalArgumentException("lengths must be non-negative");
        if (radius1 < 0 || radius2 < 0)
            throw new IllegalArgumentException("radii must be non-negative");
        if (area1 < 0 || area2 < 0)
            throw new IllegalArgumentException("areas must be non-negative");
        if (distance < 0)
            throw new IllegalArgumentException("distance must be non-negative");
        if (epsilon < 0 || epsilon >= Math.PI)
            throw new IllegalArgumentException("epsilon must be non-negative and less than pi");
        if (quads < 1 || quads > 3)
            throw new IllegalArgumentException("quads must be 1, 2 or 3");
        if (qPoints < 2)
            throw new IllegalArgumentException("qPoints must be greater than or equal to 2");
        if (nPoints < 3)
            throw new IllegalArgumentException("nPoints must be greater than or equal to 3");
        if  (kPoints < 1 || aPoints < 1 || bPoints < 1 ||
                cPoints < 1 || dPoints < 1 || ePoints < 1 ||
                fPoints < 1 || gPoints < 1)
            throw new IllegalArgumentException("separating points must be greater than or equal to 1 ");
    }
}