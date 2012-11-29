/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package johansen.stian.apd.cw4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Stian Johansen <stian.uansett@gmail.com>
 */

/*
 The recommended way of implementing this is that your filter object should be produced 
 from a separate class called  Filter<E> whose constructor takes an object of class 
 Iterator<E> (which would be here the normal iterator for the set) and an object of 
 class Checker<E> and returns an object of type Iterator<E> which gives the filtered 
 iteration.
 */
public class Filter<E> implements Iterator<E> {
    private E nextElement;
    private Iterator<E> iterator;
    private Checker<E> checker;

    public Filter(Iterator<E> iterator, Checker<E> checker) {
        this.iterator = iterator;
        this.checker = checker;
        getNextElement();
    }

    private void getNextElement() {
        if (iterator.hasNext()) {
            nextElement = iterator.next();
            if (!checker.check(nextElement)) {
                getNextElement();
            }
        } else {
            nextElement = null;
        }
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }

    @Override
    public E next() {
        if (hasNext()) {
            E elm = nextElement;
            getNextElement();
            return elm;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
