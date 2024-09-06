import { styled } from 'styled-components'

export const ListContainer = styled.section`
	width: 100%;
`;

export const StarImg = styled.img`
	width: 30px;
`;

export const ListHeaderContainer = styled.div`
	display: flex;
`;

export const ViewChangeSpanContainer = styled.span`
	float: right;
	display: inline-flex;
	justify-content: flex-start;
	background-color: rgba(102, 102, 255, 0.2);
	width: 85px;
	height: 40px;
	border-radius: 40px;
`;

export const ViewChangeSpan = styled.span`
	display: inline-block;
	width: 50px;
	height: 40px;
	background-color: rgba(102, 102, 255, 0.7);
	border-radius: 40px;
`;

export const EventSpan = styled.span`
	display: inline-flex;
	flex-wrap: wrap;
	background-color: rgba(0, 0, 0, 0.1);
`;

export const Col4 = styled.div`
	min-width: 33%;
`;