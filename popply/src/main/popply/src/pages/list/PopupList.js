import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import StarPoint from "../component/StarPoint";
import { Col4, EventSpan, ListHeaderContainer, ViewChangeSpan, ViewChangeSpanContainer } from "../styles/ListStyle";

function PopupList() {
	const [list, setList] = useState({eList:[], rPoint: {}});
	const [view, setView] = useState('list');
	const {page} = useParams();
	
	useEffect(() => {
		console.log(page)
		axios.get(`/event/${page}`)
				 .then(result => {
					 setList(result.data);
				 });
	}, [])
	
	const viewToggleHandler = () => {
		if(view === 'list'){
			setView('card')
		} else {
			setView('list')
		}
	}

	console.log(list);

  return (
		<span>
			<ListHeaderContainer>
			<h1>Pop-up List</h1>
		    <ViewChangeSpanContainer>
		    	<ViewChangeSpan onClick={viewToggleHandler}>
		    		<image src={''} />
		    	</ViewChangeSpan>
		    </ViewChangeSpanContainer>
			</ListHeaderContainer>
	    <section>
	    	{ShowList(list, view)}
	    </section>
		</span>
  );
}

function ShowList(list, view){
	
	const {eList, rPoint} = list;
	console.log(view)
	const navigate = useNavigate();
	
	// eslint-disable-next-line default-case
	switch(view){
		case 'list':
			return (
				<span>
					{eList.map((e, i) => {
						return(
							<div onClick={() => {navigate(`/event/${e.eventNo}`)}} key={e.eventNo}>
								<span>{e.eventNo}</span>&emsp;
								<span>{e.title}</span>&emsp;
								<span>{rPoint[e.eventNo] ? 
								  StarPoint(rPoint[e.eventNo]) 
								  : StarPoint(0.0)}</span>
							</div>
						)
					})}
				</span>
			)
		case 'card':
			return (
				<EventSpan>
					{eList.map((e, i) => {
						return(
							<Col4 onClick={() => {navigate(`/event/${e.eventNo}`)}} key={e.eventNo}>
								<span>{e.eventNo}</span>&emsp;
								<span>{e.title}</span>&emsp;
								<span>{rPoint[e.eventNo] ? 
								  StarPoint(rPoint[e.eventNo]) 
								  : StarPoint(0.0)}</span>
							</Col4>
						)
					})}
				</EventSpan>
			)
	}
	
}

export default PopupList;