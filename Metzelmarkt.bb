AppTitle "Metzel-Markt :D"
SeedRnd MilliSecs()
Dim dmg(11)	
Dim hs$(9)
Dim nw$(11)
Dim tx$(56)
f=ReadFile("settings.ini")
ReadLine(f)
Global nm$=ReadLine(f)
ReadLine(f)
Global x2=ReadLine(f)
Global y2=ReadLine(f)
Global depth=ReadLine(f)
Global mode=ReadLine(f)
ReadLine(f)
For i=0 To 11
	nw$(i)=ReadLine(f)
	dmg(i)=ReadLine(f)
Next
CloseFile f
f=ReadFile("txt.dat")
For i=0 To 56
	tx$(i)=ReadLine(f)
Next
CloseFile f
Graphics x2,y2,depth,mode
SetBuffer BackBuffer()
Global t=CreateTimer(60)
Global W.wp
Global pl.ch
Global sc,wc,ec,esc,xt,xfr,nos,ak#,gk#,hy#,mx,my,dfc,move,wy,ry,sw=1,mu=1,bo=1,mep=100,rne=4,esf=700,cne=5,cnw=4,mee=50,rng=1,ps=5,es=4,ctr=0,eatd=800,noe=1,time=90,pn,kl,hl
Global mf=LoadFont(tx$(55),30,1)
Global gf=LoadFont(tx$(56),20,1)
Global wpi=LoadAnimImage(tx$(33),32,32,0,24)
MaskImage wpi,255,255,255
Global chi=LoadAnimImage(tx$(34),64,64,0,60)
MaskImage chi,255,255,255
Global sli=LoadImage(tx$(35))
MaskImage sli,255,255,255
Global back=LoadImage(tx$(36))
Global s1=LoadSound(tx$(37)),s2=LoadSound(tx$(38)),s3=LoadSound(tx$(39)),s4=LoadSound(tx$(40)),d1=LoadSound(tx$(41)),d2=LoadSound(tx$(42)),d3=LoadSound(tx$(43)),d4=LoadSound(tx$(44))
Global d5=LoadSound(tx$(45)),f1=LoadSound(tx$(46)),f2=LoadSound(tx$(47)),f3=LoadSound(tx$(48)),n1=LoadSound(tx$(49)),n2=LoadSound(tx$(50)),t1=LoadSound(tx$(51))
Global t2=LoadSound(tx$(52)),t3=LoadSound(tx$(53)),e1=LoadSound(tx$(54))
f=ReadFile("hs.dat")
For i=0 To 9
	hs$(i)=ReadString(f)
Next
ResizeImage back,x2,y2
While 1
	WaitTimer(t)
	Cls()
	DrawImage back,0,0
	dfc=((1000*mee)/(rne*cne+mep+esf))
	Select mu
		Case 1,3,4,5
			Color 0,30,100
			SetFont mf
			M()
		Case 2
			SetFont gf
			D()
			St()
			W()
			P()
			E()
	End Select
	Flip 0
Wend
Function M()
	If mu=1 
		Text x2/2,y2/6,tx$(0),1,1
		Text x2/2,y2/6*2,tx$(1),1,1
		Text x2/2,y2/6*3,tx$(2),1,1
		Text x2/2,y2/6*4,tx$(3),1,1
		Text x2/2,y2/6*5,tx$(4),1,1
		Rect x2/2-200,y2/6*bo-20,400,40,0
		If KeyHit(57) 
			If bo=1 And ry=0 ry=MilliSecs()+time*1000
				If bo=5 End
				If bo=1
					For C.ch=Each ch
						Delete C
					Next
					CP()
				EndIf
				mu=bo+1
					bo = 1
			FlushKeys()
		EndIf
		If KeyHit(205) 
			If bo<5 
				bo=bo+1
			Else
				bo=1
			EndIf
		EndIf
		If KeyHit(203) 
			If bo>1 
				bo=bo-1
			Else
				bo=5
			EndIf
		EndIf
	ElseIf mu=3 
		Text x2/2,y2/14,tx$(5)+mep,1,1
		Text x2/2,y2/14*2,tx$(6)+mee,1,1
		Text x2/2,y2/14*3,tx$(7)+ps,1,1
		Text x2/2,y2/14*4,tx$(8)+es,1,1
		Text x2/2,y2/14*5,tx$(9)+cne+tx$(29),1,1
		Text x2/2,y2/14*6,tx$(10)+cnw+tx$(29),1,1
		Text x2/2,y2/14*7,tx$(11)+rne+tx$(30),1,1
		Text x2/2,y2/14*8,tx$(12)+esf+tx$(31),1,1
		Text x2/2,y2/14*9,tx$(13)+ctr,1,1
		Text x2/2,y2/14*10,tx$(14)+eatd+tx$(31),1,1
		Text x2/2,y2/14*11,tx$(15)+time+tx$(29),1,1
		Text x2/2,y2/14*12,tx$(16),1,1
		Text x2/2,y2/14*13,tx$(17)+dfc,1,1
		Rect x2/2-250,y2/14*bo-20,500,40,0
		If KeyHit(57) 
			Select bo
				Case 1
					If mep<200 
						mep=mep+10
					Else
						mep=10
					EndIf
				Case 2
					If mee<100 
						mee=mee+10
					Else
						mee=10
					EndIf
				Case 3
					If ps<10 
						ps=ps+1
					Else
						ps=1
					EndIf
				Case 4
					If es<10 
						es=es+1
					Else
						es=1
					EndIf
				Case 5
					If cne<8 
						cne=cne+1
					Else
						cne=2
					EndIf
				Case 6
					If cnw<10 
						cnw=cnw+1
					Else
						cnw=1
					EndIf
				Case 7
					If rne<10 
						rne=rne+1
					Else
						rne=1
					EndIf
				Case 8
					If esf<1500 
						esf=esf+100
					Else
						esf=100
					EndIf
				Case 9
					ctr=1-ctr
				Case 10
					If eatd<1500 
						eatd=eatd+100
					Else
						eatd=500
					EndIf
				Case 11
					If time<210 
						time=time+10
					Else
						time=30
					EndIf 
				Case 12
					bo=1
					mu=1
			End Select
			FlushKeys()
		EndIf
		If KeyHit(205) 
			If bo<12 
				bo=bo+1
			Else
				bo=1
			EndIf
		EndIf
		If KeyHit(203) 
			If bo>1 
				bo=bo-1
			Else
				bo=12
			EndIf
		EndIf
	ElseIf mu=4 
		For i=0 To 9
			If hl=i Color 255,60,0
			Text x2/2,y2/12*(i+1),hs$(i),1,1 
			Color 0,30,100 
		Next
		Text x2/2,y2/12*11,tx$(18),1,1
		If KeyHit(57) mu=1 : FlushKeys()
		ElseIf mu=5 
			Text x2/2,y2/6,tx$(19),1,1
			Text x2/2,y2/6*2,tx$(20),1,1
			Text x2/2,y2/6*3,tx$(21),1,1
			Text x2/2,y2/6*4,tx$(22),1,1
			Text x2/2,y2/6*5,tx$(23),1,1
		If KeyHit(57) mu=1 : FlushKeys()
		EndIf
End Function 
Function P()
	pl.ch=First ch
	If pl\en=-1 pl\en=mep
	Color 255,255,255
	Text x2/2,20,tx$(24)+pn,1,1
	Text x2/2,80,tx$(25)+pl\am,1,1
	If pl\wp>0 
		Text x2/2,50,tx$(26)+nw$(pl\wp/2),1,1
	Else
		Text x2/2,50,tx$(27),1,1
	EndIf	
	Color 255,0,0
	Rect pl\x#,pl\y#,mep,10
	Color 0,255,0
	Rect pl\x#,pl\y#,pl\en,10
	move = (MilliSecs()>wy)
	If KeyDown(200) 
		pl\x#=pl\x#+Sin(pl\A)*ps
		pl\y#=pl\y#-Cos(pl\A)*ps
	EndIf
	If KeyDown(203) And move  
		pl\A = pl\A-30
		If pl\A<0 pl\A=360+pl\A
			move=0
			wy=MilliSecs()+100
	EndIf
	If KeyDown(205) And move 
		pl\A = pl\A+30
		If pl\A>359 pl\A=pl\A-360
			move=0
			wy=MilliSecs()+100
	EndIf 
	If KeyDown(57) And pl\wp>=0 
		If sw sc=MilliSecs() : sw=0
		Color 200,20,20
		Rect pl\x#,pl\y#-20,(eatd/10),10
		Color 20,20,255
		Rect pl\x#,pl\y#-20,((MilliSecs()-sc)/10),10
	EndIf 
	If (Not (KeyDown(57))) And sw = 0 
		If (MilliSecs()-sc>=eatd) And pl\en<mep 
			pl\en=pl\en+(pl\wp+pl\am)
			If pl\en>mep pl\en=mep
				pl\am=-1
				pl\wp=-1
			PlaySound e1
		Else
			If ctr 
				CW(pl\wp-1,pl\x,pl\y,pl\A,Int((MilliSecs()-sc)/5),0)
			Else
				CW(pl\wp-1,pl\x,pl\y,pl\A,100,0)
			EndIf
			r=Rnd(1,3)
			If r=1 PlaySound t1
				If r=2 PlaySound t2
					If r=3 PlaySound t3
			pl\am=pl\am-1
			If pl\am=0 
				pl\wp=-1
				pl\am=-1
			EndIf
		EndIf
		sw=1
	EndIf 
	Text x2/2,100,tx$(28)+(ry-MilliSecs())/1000+tx$(29),1,1
		If (MilliSecs()>=ry) Or (pl\en<=0) Or KeyHit(1) 
		If pn>10000 
			j$=nm$+": "+pn+tx$(32)
			If pn>100000 pn=100000
				q=10-Int(pn/10000)
				hs$(q)=j : hl=q
			f = WriteFile("hs.dat")
			For i=0 To 9
				WriteString(f,hs$(i))
			Next
			CloseFile f
		EndIf
		ry=0
		pn=0
		kl=0
		noe=1
		nos=0
		For C.ch=Each ch
			Delete C.ch
		Next
		For W.wp=Each wp
			Delete W.wp
		Next
		For S.sl=Each sl
			Delete S.sl
		Next
		For D.dt=Each dt
			Delete D.dt
		Next
		mu=4
		FlushKeys()
	EndIf 
End Function
Function E()
	For C.ch=Each ch
		DrawImage chi,C\x#,C\y#,(C\k*12+(C\a/30))
		If C\fg<>10 
			Color 255,0,0
			Rect C\x#,C\y#,mee,10
			Color 0,255,0
			Rect C\x#,C\y#,C\en,10
			C\x#=C\x#+Sin(C\a)*C\sd#
			C\y#=C\y#-Cos(C\a)*C\sd#
			If C\x#<=10 Or C\x#>=x2-64 Or C\y#<=110 Or C\y#>y2-64 
				If C\a>=180 
					C\a=C\a-180
				Else
					C\a=C\a+180
				EndIf
			EndIf
			If C\mc<MilliSecs() 
				C\mc=MilliSecs()+3000
				If C\fg<> 2 C\a=Rnd(0,11)*30
			EndIf 
		EndIf 
		If C\fg>1 And C\fg<>10 
			W.wp=First wp
			If C\am>0 And C\fg=2 
				ak#=A#(pl\x#,C\x#)
				gk#=G#(pl\y#,C\y#)
			ElseIf C\am<0 And W.wp<>Null 
				ak#=A#(W\x#,C\x#)
				gk#=G#(W\y#,C\y#)
			EndIf 
			hy#=H#(ak#,gk#)
			If S#(gk#,hy#)>Sin(0) And S#(gk#,hy#)<=Sin(30) And Sgn(C#(ak#,hy#))=1 
				C\a=90
			ElseIf S#(gk#,hy#)>Sin(30) And S#(gk#,hy#)<=Sin(60) And Sgn(C#(ak#,hy#))=1 	
				C\a=60
			ElseIf S#(gk#,hy#)>Sin(60) And S#(gk#,hy#)<=Sin(90) And Sgn(C#(ak#,hy#))=1 	
				C\a=30
			ElseIf S#(gk#,hy#)<Sin(90) And S#(gk#,hy#)>=Sin(60) And Sgn(C#(ak#,hy#))=-1 	
				C\a=0
			ElseIf S#(gk#,hy#)<Sin(60) And S#(gk#,hy#)>=Sin(30) And Sgn(C#(ak#,hy#))=-1 	
				C\a=330
			ElseIf S#(gk#,hy#)<Sin(30) And S#(gk#,hy#)>=Sin(0) And Sgn(C#(ak#,hy#))=-1 	
				C\a=300
			ElseIf S#(gk#,hy#)<Sin(0) And S#(gk#,hy#)>=-Sin(30) And Sgn(C#(ak#,hy#))=-1 	
				C\a=270
			ElseIf S#(gk#,hy#)<-Sin(30) And S#(gk#,hy#)>=-Sin(60) And Sgn(C#(ak#,hy#))=-1 	
				C\a=240
			ElseIf S#(gk#,hy#)<-Sin(60) And S#(gk#,hy#)>=-Sin(90) And Sgn(C#(ak#,hy#))=-1 
				C\a=210
			ElseIf S#(gk#,hy#)>-Sin(90) And S#(gk#,hy#)<=-Sin(60) And Sgn(C#(ak#,hy#))=1 	
				C\a=180
			ElseIf S#(gk#,hy#)>-Sin(60) And S#(gk#,hy#)<=-Sin(30) And Sgn(C#(ak#,hy#))=1 	
				C\a=150
			ElseIf S#(gk#,hy#)>-Sin(30) And S#(gk#,hy#)<=-Sin(0) And Sgn(C#(ak#,hy#))=1 	
				C\a=120
			EndIf 
			If ((Abs(C\x#-pl\x#)<(x2/10) Or Abs(C\y#-pl\y#)<(y2/9)) Or C\fg=3) And C\am > 0 
				C\sd#=0
				If esc<MilliSecs() 
					esc=MilliSecs()+esf
					CW(C\wp-1,C\x,C\y,C\a,100,C\k)
					C\am=C\am-1
					If C\am=0 
						C\wp=-1
						C\am=-1
					EndIf
					Exit
				EndIf
			Else
				C\sd#=Rnd(es/2,es)
			EndIf 
		EndIf
		If C\en<=0 
			pn=pn+dfc*10
			kl=kl+1
			Delete C.ch
			r=Rnd(1,5)
			If r=1 PlaySound d1
				If r=2 PlaySound d2
					If r=3 PlaySound d3
						If r=4 PlaySound d4
							If r=5 PlaySound d5
			Exit
		EndIf
	Next 
	If ec<MilliSecs() 
		ec=MilliSecs()+cne*1000
		For i=1 To noe
			C.ch=New ch
			C\k=Rnd(1,4)
			C\x#=Rnd(10,x2-64)
			C\y#=Rnd(110,y2-64)
			C\a=Rnd(0,11)*30
			C\fg=0						
			C\wp=-1								
			C\am=-1									
			C\en=Rnd(mee/2,mee)
			C\sd#=Rnd(es/2,es)
			C\mc=0
		Next
	EndIf 
	If kl Mod rne=0 And kl>0 noe=noe+1 : kl=0
End Function
Function W()
	For W.wp = Each wp
		DrawImage wpi,W\x#,W\y#,W\k
		If W\r>0 
			W\x#=W\x#+Sin(W\a)*10
			W\y#=W\y#-Cos(W\a)*10
			W\r=W\r-1
			For C.ch=Each ch
				If (C\k<>W\sh) And ImagesOverlap(wpi,W\x#,W\y#,chi,C\x#,C\y#) 
					C\en=C\en-dmg(W\k/2)
					C\sd#=es
					If W\sh=0 pn=pn+dfc
						If C\fg=0 
							C\fg=Rnd(1,3)
						Select C\fg
							Case 1
								r=Rnd(1,4)
								If r=1 PlaySound s1
									If r=2 PlaySound s2
										If r=3 PlaySound s3
											If r=4 PlaySound s4
							Case 2
								r = Rnd(1,3)
								If r=1 PlaySound f1
									If r=2 PlaySound f2
										If r=3 PlaySound f3
							Case 3
								r = Rnd(1,2)
								If r=1 PlaySound n1
									If r=2 PlaySound n2
						End Select
					EndIf
					D.dt=New dt
					D\x#=W\x
					D\y#=W\y
					D\w=Rnd(5,20)
					D\h=Rnd(5,20)
					D\r=Rnd(0,255)
					D\g=Rnd(0,255)
					D\b=Rnd(0,255)
					Delete W.wp
					Exit
				EndIf
			Next
		ElseIf W\r=0 
			D.dt=New dt
			D\x#=W\x
			D\y#=W\y
			D\w=Rnd(5,20)
			D\h=Rnd(5,20)
			D\r=Rnd(0,255)
			D\g=Rnd(0,255)
			D\b=Rnd(0,255)
			Delete W.wp
		Else If W\r=-1 
			For C.ch=Each ch
				If ImagesOverlap(chi,C\x#,C\y#,wpi,W\x#,W\y#) And C\fg>1 
					If C\wp=W\k 
						C\am=C\am+Rnd(13-(W\k/2),20-(W\k/2))
						Delete W.wp
						Exit
					ElseIf W\k>C\wp 
						C\wp=W\k
						C\am=Rnd(13-(W\k/2),30-(W\k/2))
						Delete W.wp
						Exit 
					EndIf
				EndIf
			Next
		EndIf 
		
	Next
End Function 
Function St()
	If (ry-MilliSecs())/1000=time And nos=0 
		For i=1 To 3
			z.sl=New sl
			z\x#=Rnd(10,x2-128)
			z\y#=Rnd(150,y2-128)
			z\k=i*2-1
			nos=nos+1
		Next
	ElseIf time-((ry-MilliSecs())/1000)>=nos*cnw And nos<=11 
		z.sl=New sl
		z\x#=Rnd(10,x2-128)
		z\y#=Rnd(150,y2-128)
		z\k=2*nos+1
		nos=nos+1
	EndIf
	For z.sl=Each sl
		DrawImage sli,z\x#,z\y#
		If z\wc<MilliSecs() 
			z\wc=MilliSecs()+cnw*1000
			CW(z\k,Rnd(z\x#,z\x#+90),Rnd(z\y#,z\y#+40),0,-1,0)
		EndIf 
	Next
End Function 
Function D()
	For D.dt=Each dt
		Color D\r,D\g,D\b
		Oval D\x#,D\y#,D\w,D\h
	Next
End Function 
Function CP()
	pl.ch=New ch
	pl\k=0
	pl\x#=Rnd(30,x2-64)
	pl\y#=Rnd(130,y2-64)
	pl\A=0
	pl\fg=10
	pl\wp=-1				
	pl\am=-1				
	pl\en=-1
End Function 
Function CW(w1,w2,w3,w4,w5,w6)
	W.wp=New wp
	W\k=w1
	W\x=w2
	W\y=w3
	W\a=w4
	W\r=w5
	W\sh=w6
End Function
Function A#(x1#,x2#)
	Return x1#-x2#
End Function
Function G#(y1#,y2#)
	Return y1#-y2#
End Function 
Function H#(ank#,geg#)
	Return Sqr(ank#*ank#+geg#*geg#)
End Function
Function S#(geg#,hyp#)
	Return -geg#/hyp#
End Function
Function C#(ank#,hyp#)
	Return ank#/hyp#
End Function 
Type wp
	Field k,x#,y#,A,r,sh
End Type
Type ch
	Field k,x#,y#,A,fg,wp,am,en,sd#,mc
End Type
Type sl
	Field x#,y#,k,wc
End Type 
Type dt
	Field x#,y#,w,h,r,g,b
End Type
;~IDEal Editor Parameters:
;~F#44#DB#13D#1A5#1EE#206#20C#217#220#223#226#229#22C#22F#232#235#238
;~C#Blitz3D