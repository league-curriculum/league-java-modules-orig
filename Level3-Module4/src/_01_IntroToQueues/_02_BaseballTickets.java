/*
 * Copyright (c) 2020, <GiacomoSorbi> All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. The views and conclusions contained in the
 * software and documentation are those of the authors and should not be
 * interpreted as representing official policies, either expressed or implied,
 * of the FreeBSD Project.
 */

package _01_IntroToQueues;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
 * OBJECTIVE: Complete the calculateWaitTime() method to return the amount of
 * time it takes to get the tickets.
 *  
 * You managed to send your friend to queue for tickets in your stead, but
 * there is a catch: he will get there only if you tell him how much that is
 * going to take. And everybody can only take ONE TICKET at a time, then they
 * go back in the last position of the queue if they need more (or go home if
 * they are fine).
 * 
 * Each ticket takes one minutes to emit with no wasted time between purchases.
 * You will be given a queue with all the people queuing and the initial
 * position of your buddy.
 * 
 * Example:
 * queue: [2, 5, 3, 4, 6]
 * position: 1 (the person who wants to buy 5 tickets)
 * 
 * The first person buys 1 ticket then moves to the back of the queue because
 * they still need to buy 1 more ticket. Everyone else moves up the queue.
 * queue: [5, 3, 4, 6, 1]
 * 
 * Now it's your turn to buy a ticket. You buy 1 and move to the back of the
 * queue because you still need to buy 4 more
 * queue: [3, 4, 6, 1, 4]
 *
 * For this queue it takes a total of 18 minutes!
 */

public class _02_BaseballTickets {

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(2, 5, 3, 6, 4); 
        ArrayDeque<Integer> ticketsQueue = new ArrayDeque<Integer>(list);
        
        assertEquals(6,  calculateWaitTime(ticketsQueue, 0));
    }
    
    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(2, 5, 3, 6, 4); 
        ArrayDeque<Integer> ticketsQueue = new ArrayDeque<Integer>(list);
        
        assertEquals(18, calculateWaitTime(ticketsQueue, 1));
    }
    
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(2, 5, 3, 6, 4); 
        ArrayDeque<Integer> ticketsQueue = new ArrayDeque<Integer>(list);
        
        assertEquals(12, calculateWaitTime(ticketsQueue, 2));
    }
    
    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(2, 5, 3, 6, 4); 
        ArrayDeque<Integer> ticketsQueue = new ArrayDeque<Integer>(list);
        
        assertEquals(20, calculateWaitTime(ticketsQueue, 3));
    }
    
    @Test
    public void test5() {
        List<Integer> list = Arrays.asList(2, 5, 3, 6, 4); 
        ArrayDeque<Integer> ticketsQueue = new ArrayDeque<Integer>(list);
        
        assertEquals(17, calculateWaitTime(ticketsQueue, 4));
    }
    
    public int calculateWaitTime( ArrayDeque<Integer> ticketsQueue, int position ) {
        int totalTimeMin = 0;
            
        while( ! ticketsQueue.isEmpty() ){
            totalTimeMin += 1;
            
            int numTickets = ticketsQueue.remove() - 1;
            
            if( position == 0 && numTickets == 0) {
                break;
            }
            
            if( numTickets != 0 ) {
                ticketsQueue.add(numTickets);
            }
            
            position -= 1;
            
            if( position < 0 ) {
                position = ticketsQueue.size() - 1;
            }
        }

        return totalTimeMin;
    }
}
