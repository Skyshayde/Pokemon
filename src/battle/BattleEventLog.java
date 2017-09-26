package battle;

import common.EventLog;

public class BattleEventLog {
	private Event[] events;
	public int currentIdx;
	private final int NUM_OF_EVENTS = 10; //TODO change
	
	public BattleEventLog() {
		events = new Event[NUM_OF_EVENTS];
		for (int i = 0; i < NUM_OF_EVENTS; i++) {
			events[i] = new Event();
		}
		battleLog();
		
		currentIdx = 0;
	}
	
	private void battleLog() {
		//hardcoded log - battle never changes
		events[0].text = "[BATTLE]: [1] (start/text) battle start, trainers and text";
		events[1].text = "[BATTLE]: [2] (animation/text) pokemon are released onto the field";
		events[2].text = "[BATTLE]: [3] (animation) text and pokemon bob up and down while waiting for turn";
		// ... TODO
	}

	public void next() {
		events[currentIdx].mark();
		EventLog.write(events[currentIdx].text);
		
		currentIdx++;
		if (currentIdx == NUM_OF_EVENTS) {
			//TODO cause battle panel close
			Battle.end();
		}
	}
	
	public Event getEvent() {
		return events[currentIdx];
	}
	
	public boolean eventComplete() {
		return events[currentIdx].isComplete();
	}
	
	//TODO separate class into common package?
	private class Event {
		public String text;
		private boolean complete;
		
		public Event() {
			text = "";
			complete = false;
		}
		
		public void mark() {
			complete = true;
		}
		
		public boolean isComplete() {
			return complete;
		}
	}
}
