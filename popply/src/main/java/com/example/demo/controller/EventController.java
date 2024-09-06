package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Event;
import com.example.demo.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	EventService eventService;

	@GetMapping("/{page}")
	public ResponseEntity<HashMap<String, Object>> getAllList(@PathVariable(name="page") String type) {
		HashMap<String, Object> result = new HashMap<>();
		double point = 0.0d;
		
		// event 모든 리스트 쿼리
		List<Event> eList = new ArrayList<>();
		Event e1 = new Event();
		e1.setEventNo(1l);
		e1.setTitle("이벤트1");
		e1.setStartDate(LocalDate.of(2024, 9, 1));
		e1.setEndDate(LocalDate.of(2024, 9, 14));
		eList.add(e1);
		
		Event e2 = new Event();
		e2.setEventNo(2l);
		e2.setTitle("이벤트2");
		e2.setStartDate(LocalDate.of(2024, 12, 11));
		e2.setEndDate(LocalDate.of(2024, 12, 25));
		eList.add(e2);

		Event e3 = new Event();
		e3.setEventNo(3l);
		e3.setTitle("이벤트3");
		e3.setStartDate(LocalDate.of(2024, 9, 10));
		e3.setEndDate(LocalDate.of(2024, 9, 24));
		eList.add(e3);

		Event e4 = new Event();
		e4.setEventNo(4l);
		e4.setTitle("이벤트4");
		e4.setStartDate(LocalDate.of(2024, 11, 17));
		e4.setEndDate(LocalDate.of(2024, 12, 1));
		eList.add(e4);

		Event e5 = new Event();
		e5.setEventNo(5l);
		e5.setTitle("이벤트5");
		e5.setStartDate(LocalDate.of(2024, 11, 17));
		e5.setEndDate(LocalDate.of(2024, 12, 1));
		eList.add(e5);

		Event e6 = new Event();
		e6.setEventNo(6l);
		e6.setTitle("이벤트6");
		e6.setStartDate(LocalDate.of(2024, 10, 10));
		e6.setEndDate(LocalDate.of(2024, 10, 24));
		eList.add(e6);

		Event e7 = new Event();
		e7.setEventNo(7l);
		e7.setTitle("이벤트7");
		e7.setStartDate(LocalDate.of(2024, 12, 2));
		e7.setEndDate(LocalDate.of(2024, 12, 16));
		eList.add(e7);

		Event e8 = new Event();
		e8.setEventNo(8l);
		e8.setTitle("이벤트8");
		e8.setStartDate(LocalDate.of(2024, 9, 5));
		e8.setEndDate(LocalDate.of(2024, 9, 19));
		eList.add(e8);

		Event e9 = new Event();
		e9.setEventNo(9l);
		e9.setTitle("이벤트9");
		e9.setStartDate(LocalDate.of(2024, 10, 28));
		e9.setEndDate(LocalDate.of(2024, 11, 11));
		eList.add(e9);

		Event e10 = new Event();
		e10.setEventNo(10l);
		e10.setTitle("이벤트10");
		e10.setStartDate(LocalDate.of(2024, 12, 23));
		e10.setEndDate(LocalDate.of(2024, 1, 6));
		eList.add(e10);
		
		// review group by event_no 쿼리
		HashMap<Long, Double> rPoint = new HashMap<>();
		rPoint.put(1l, 3.5d);
		rPoint.put(2l, 4.0d);
		rPoint.put(3l, 2.8d);
		rPoint.put(4l, 4.5d);
		rPoint.put(5l, 3.2d);
		rPoint.put(6l, 4.7d);
		rPoint.put(7l, 3.9d);
		rPoint.put(8l, 4.3d);
		rPoint.put(9l, 2.5d);
		rPoint.put(10l, 3.8d);
		
		/* 의사코드
		 * 인터페이스 domain/ReviewPoint.java
		 * 	(
		 * 	 Long getEventId(EVENT_ID), 
		 * 	 Double getReviewPointAverage(avg(RATE))
		 * 	)
		 * for(ReviewPoint rp : reviewService.getReviewPointAvg()){
		 * 	rPoint.put(rp.getEventId, rp.getReviewPointAverage);
		 * }
		 */
		
		result.put("eList", eList);
		result.put("rPoint", rPoint);
		
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/detail/{eventNo}")
	public Event eventinfo(@PathVariable(name="eventNo") Long eventNo) {
		System.out.println("이벤트 번호 : " +  eventNo);
		return eventService.eventinfo(eventNo).get();
	}
	
	
	
}