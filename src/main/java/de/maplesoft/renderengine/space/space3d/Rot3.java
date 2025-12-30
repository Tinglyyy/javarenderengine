package de.maplesoft.renderengine.space.space3d;

import de.maplesoft.renderengine.space.util.MathUtils;
import lombok.Getter;
import lombok.Setter;

public class Rot3 {
    @Getter @Setter
    private double alpha, beta, gamma;

    public Rot3(double alpha, double beta, double gamma) {
       this.alpha = MathUtils.reduceAngle(alpha);
       this.beta = MathUtils.reduceAngle(beta);
       this.gamma = MathUtils.reduceAngle(gamma);
    }

    public Rot3 add(Rot3 other) {
        this.alpha = MathUtils.reduceAngle(this.alpha + other.alpha);

        this.beta = MathUtils.reduceAngle(this.beta + other.beta);

        this.gamma = MathUtils.reduceAngle(this.gamma + other.gamma);

        return this;
    }

    public Rot3 addAlpha(double alpha) {
        this.alpha = MathUtils.reduceAngle(this.alpha + alpha);
        return this;
    }

    public Rot3 addBeta(double beta) {
        this.beta = MathUtils.reduceAngle(this.beta + beta);
        return this;
    }

    public Rot3 addGamma(double gamma) {
        this.gamma = MathUtils.reduceAngle(this.gamma + gamma);
        return this;
    }

    public Rot3 subtract(Rot3 other) {
        this.alpha = MathUtils.reduceAngle(this.alpha - other.alpha);

        this.beta = MathUtils.reduceAngle(this.beta - other.beta);

        this.gamma = MathUtils.reduceAngle(this.gamma - other.gamma);

        return this;
    }

    public Rot3 subtractAlpha(double alpha) {
        this.alpha = MathUtils.reduceAngle(this.alpha - alpha);
        return this;
    }

    public Rot3 subtractBeta(double beta) {
        this.beta = MathUtils.reduceAngle(this.beta - beta);
        return this;
    }

    public Rot3 subtractGamma(double gamma) {
        this.gamma = MathUtils.reduceAngle(this.gamma - gamma);
        return this;
    }

    public Rot3 multiply(double scalar) {
        this.alpha = MathUtils.reduceAngle(this.alpha * scalar);

        this.beta = MathUtils.reduceAngle(this.beta * scalar);

        this.gamma = MathUtils.reduceAngle(this.gamma * scalar);

        return this;
    }

    public Rot3 divide(double scalar) {
        this.alpha = MathUtils.reduceAngle(this.alpha / scalar);

        this.beta = MathUtils.reduceAngle(this.beta / scalar);

        this.gamma = MathUtils.reduceAngle(this.gamma / scalar);

        return this;
    }

    public Rot3 flip() {
        this.alpha = MathUtils.reduceAngle(this.alpha + 180);

        this.beta = MathUtils.reduceAngle(this.beta + 180);

        this.gamma = MathUtils.reduceAngle(this.gamma + 180);

        return this;
    }

    public Rot3 flipAlpha() {
        this.alpha = MathUtils.reduceAngle(this.alpha + 180);
        return this;
    }

    public Rot3 flipBta() {
        this.beta = MathUtils.reduceAngle(this.beta + 180);
        return this;
    }

    public Rot3 flipGamma() {
        this.gamma = MathUtils.reduceAngle(this.gamma + 180);
        return this;
    }

    public static Rot3 zero() {
        return new Rot3(0, 0, 0);
    }
}
