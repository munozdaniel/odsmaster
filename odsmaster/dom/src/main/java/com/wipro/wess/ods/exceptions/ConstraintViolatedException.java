package com.wipro.wess.ods.exceptions;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import com.wipro.wess.ods.exceptions.constraints.Constraint;

public class ConstraintViolatedException extends Exception {

    private static final long serialVersionUID = -6960954878227263559L;

    private Collection<Constraint> constraints = new HashSet<Constraint>();

    public String toString() {
        StringBuffer buf = new StringBuffer(super.toString());
        buf.append(" [");
        for (Constraint ct : this.constraints) {
            buf.append(ct.toString());
            buf.append("; ");
        }
        buf.append("]");
        return buf.toString();
    }

    public ConstraintViolatedException(Throwable cause, String message) {
        super(message, cause);
    }

    public ConstraintViolatedException(String message) {
        super(message);
    }

    public ConstraintViolatedException(Collection<Constraint> constraintList, String message) {
        super(message);
        this.constraints.addAll(constraintList);
    }

    public ConstraintViolatedException(Collection<Constraint> constraintList) {
        this.constraints.addAll(constraintList);
    }

    public ConstraintViolatedException() {
    }

    public ConstraintViolatedException removeConstraint(Constraint constraint) {
        this.constraints.remove(constraint);
        return this;
    }

    public ConstraintViolatedException addConstraint(Constraint constraint) {
        this.constraints.add(constraint);
        return this;
    }

    public Collection<Constraint> getConstraints() {
        return Collections.unmodifiableCollection(this.constraints);
    }

    public ConstraintViolatedException addConstraints(Collection<Constraint> constraints) {
        this.constraints.addAll(constraints);
        return this;
    }

    public ConstraintViolatedException setConstraints(Collection<Constraint> constraints) {
        this.constraints = constraints;
        return this;
    }

    public ConstraintViolatedException(String message, Throwable cause, Collection<Constraint> constraints) {
        super(message, cause);
        constraints.addAll(constraints);
    }

    public ConstraintViolatedException(String message, Collection<Constraint> constraintList) {
        super(message);
        this.constraints.addAll(constraintList);
    }
}
