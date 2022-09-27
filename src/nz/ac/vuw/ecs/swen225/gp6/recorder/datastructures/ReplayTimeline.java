package nz.ac.vuw.ecs.swen225.gp6.recorder.datastructures;

import java.util.Stack;

public class ReplayTimeline<E> {
    private Stack<Pair<Long, E>> forward;
    private Stack<Pair<Long, E>> backward;

    /**
     * Creates a new Timeline
     * @param timeline the timeline to replay
     */
    public ReplayTimeline(Stack<Pair<Long, E>> timeline) {
        this.forward = new Stack<>();
        this.backward = new Stack<>();
        while(!timeline.isEmpty()){
            forward.push(timeline.pop());    // reverse stack
        }
    }

    /**
     * Returns the next action in the timeline.
     * @return returns the time and event of the next action
     */
    public Pair<Long, E> next() {
        Pair<Long, E> action = forward.pop();
        backward.push(action);
        return action;
    }

    /**
     * Returns the previous action in the timeline.
     * @return returns the time and event of the previous action
     */
    public Pair<Long, E> previous() {
        Pair<Long, E> action = backward.pop();
        forward.push(action);
        return action;
    }

    /**
     * Checks if there are any more actions in the timeline
     * @return boolean if there are more actions
     */
    public boolean hasNext() { 
        return !this.forward.isEmpty();
    }

    /**
     * Checks if there are any previous actions in the timeline
     * @return boolean if there are previous actions
     */
    public boolean hasPrevious() {
        return !this.backward.isEmpty();
    }

    @Override
    public String toString() {
        return "Timeline {Previous actions: " + this.backward.toString() +
                ", Next actions: " + this.forward.toString() + "}";        
    }
}
