$().ready(function() {
	// 투어 희망 정보를 입력할 때 추가하기 버튼을 누르면 실행
	$("#plus").on("click", function() {
		// 가상 돔으로 추가되는 div의 길이를 구함 -> index를 알기 위해
		var locsCnt = $(".locs").length;
		// userTourWriteVO에 있는 List<UserTourSchdlVO> userTourSchdulList에게 리스트 형식으로 담아줌
		// -> name="userTourSchdlList[index].컬럼명" -> 해당 컬럼에 리스트 형식으로 담음
		// 해당 방법을 사용하기 위해서는 모든 input태그를 감싸고있는 div가 하나 필요함 -> <div class="locs">...</div>
		var plusDom = $(`<div class="locs"><div>
							<label for="hope-location">장소</label>
							<input id="hope-location" name="userTourSchdlList[${locsCnt}].trLctns" type="text"/>
						</div>
						<div>
							<label for="hope-info">일정</label>
							<input id="hope-info" name="userTourSchdlList[${locsCnt}].trRqst" type="text"/>
						</div></div>`);
		// 인덱스가 담긴 가상 돔을 .loc-inf의 안쪽에 담아준다.
		$(".loc-inf").append(plusDom);
	});

	!(function(t) {
		(EditableSelect = function(e, i) {
			(this.options = i),
				(this.$select = t(e)),
				(this.$input = t('<input type="text" autocomplete="off">')),
				(this.$list = t('<ul class="es-list">')),
				(this.utility = new EditableSelectUtility(this)),
				["focus", "manual"].indexOf(this.options.trigger) < 0 &&
				(this.options.trigger = "focus"),
				["default", "fade", "slide"].indexOf(this.options.effects) < 0 &&
				(this.options.effects = "default"),
				isNaN(this.options.duration) &&
				["fast", "slow"].indexOf(this.options.duration) < 0 &&
				(this.options.duration = "fast");
			var s = t._data(e, "events");
			s &&
				Object.keys(s).forEach((t) => {
					var e = s[t][0];
					this.$input.bind(e.type + "." + e.namespace, e.handler);
				}),
				this.$select.replaceWith(this.$input),
				this.$list.appendTo(this.options.appendTo || this.$input.parent()),
				this.utility.initialize(),
				this.utility.initializeList(),
				this.utility.initializeInput(),
				this.utility.trigger("created");
		}),
			(EditableSelect.DEFAULTS = {
				filter: !0,
				effects: "default",
				duration: "fast",
				trigger: "focus",
			}),
			(EditableSelect.prototype.filter = function() {
				var e = 0,
					i = this.$input.val().toLowerCase().trim();
				this.$list.find("li").addClass("es-visible").show(),
					this.options.filter &&
					((e = this.$list
						.find("li")
						.filter(function(e, s) {
							return t(s).text().toLowerCase().indexOf(i) < 0;
						})
						.hide()
						.removeClass("es-visible").length),
						this.$list.find("li").length == e && this.hide());
			}),
			(EditableSelect.prototype.show = function() {
				if (
					(this.$list.css({
						top: this.$input.position().top + this.$input.outerHeight() - 1,
						left: this.$input.position().left,
						width: this.$input.outerWidth(),
					}),
						!this.$list.is(":visible") &&
						this.$list.find("li.es-visible").length > 0)
				) {
					var e = { default: "show", fade: "fadeIn", slide: "slideDown" }[
						this.options.effects
					];
					this.utility.trigger("show"),
						this.$input.addClass("open"),
						this.$list[e](
							this.options.duration,
							t.proxy(this.utility.trigger, this.utility, "shown")
						);
				}
			}),
			(EditableSelect.prototype.hide = function() {
				var e = { default: "hide", fade: "fadeOut", slide: "slideUp" }[
					this.options.effects
				];
				this.utility.trigger("hide"),
					this.$input.removeClass("open"),
					this.$list[e](
						this.options.duration,
						t.proxy(this.utility.trigger, this.utility, "hidden")
					);
			}),
			(EditableSelect.prototype.select = function(t) {
				this.$list.has(t) &&
					t.is("li.es-visible:not([disabled])") &&
					(this.$input.val(t.text()),
						this.options.filter && this.hide(),
						this.filter(),
						this.utility.trigger("select", t));
			}),
			(EditableSelect.prototype.add = function(e, i, s, l) {
				var o = t("<li>").html(e),
					n = t("<option>").text(e),
					a = this.$list.find("li").length;
				0 == (i = isNaN(i) ? a : Math.min(Math.max(0, i), a))
					? (this.$list.prepend(o), this.$select.prepend(n))
					: (this.$list
						.find("li")
						.eq(i - 1)
						.after(o),
						this.$select
							.find("option")
							.eq(i - 1)
							.after(n)),
					this.utility.setAttributes(o, s, l),
					this.utility.setAttributes(n, s, l),
					this.filter();
			}),
			(EditableSelect.prototype.remove = function(t) {
				var e = this.$list.find("li").length;
				(t = isNaN(t) ? e : Math.min(Math.max(0, t), e - 1)),
					this.$list.find("li").eq(t).remove(),
					this.$select.find("option").eq(t).remove(),
					this.filter();
			}),
			(EditableSelect.prototype.clear = function() {
				this.$list.find("li").remove(),
					this.$select.find("option").remove(),
					this.filter();
			}),
			(EditableSelect.prototype.destroy = function() {
				this.$list.off("mousemove mousedown mouseup"),
					this.$input.off("focus blur input keydown"),
					this.$input.replaceWith(this.$select),
					this.$list.remove(),
					this.$select.removeData("editable-select");
			}),
			(EditableSelectUtility = function(t) {
				this.es = t;
			}),
			(EditableSelectUtility.prototype.initialize = function() {
				var e = this;
				e.setAttributes(
					e.es.$input,
					e.es.$select[0].attributes,
					e.es.$select.data()
				),
					e.es.$input.addClass("es-input").data("editable-select", e.es),
					e.es.$select.find("option").each(function(i, s) {
						var l = t(s).remove();
						e.es.add(l.text(), i, s.attributes, l.data()),
							l.attr("selected") && e.es.$input.val(l.text());
					}),
					e.es.filter();
			}),
			(EditableSelectUtility.prototype.initializeList = function() {
				var e = this;
				e.es.$list
					.on("mousemove", "li:not([disabled])", function() {
						e.es.$list.find(".selected").removeClass("selected"),
							t(this).addClass("selected");
					})
					.on("mousedown", "li", function(i) {
						t(this).is("[disabled]")
							? i.preventDefault()
							: e.es.select(t(this));
					})
					.on("mouseup", function() {
						e.es.$list.find("li.selected").removeClass("selected");
					});
			}),
			(EditableSelectUtility.prototype.initializeInput = function() {
				var e = this;
				switch (this.es.options.trigger) {
					default:
					case "focus":
						e.es.$input.on("focus", t.proxy(e.es.show, e.es)).on(
							"blur",
							t.proxy(function() {
								0 === t(".es-list:hover").length
									? e.es.hide()
									: this.$input.focus();
							}, e.es)
						);
						break;
					case "manual":
				}
				e.es.$input.on("input keydown", function(t) {
					switch (t.keyCode) {
						case 38:
							var i = (s = e.es.$list.find(
								"li.es-visible:not([disabled])"
							)).index(s.filter("li.selected"));
							e.highlight(i - 1), t.preventDefault();
							break;
						case 40:
							var s;
							i = (s = e.es.$list.find("li.es-visible:not([disabled])")).index(
								s.filter("li.selected")
							);
							e.highlight(i + 1), t.preventDefault();
							break;
						case 13:
							e.es.$list.is(":visible") &&
								(e.es.select(e.es.$list.find("li.selected")),
									t.preventDefault());
							break;
						case 9:
						case 27:
							e.es.hide();
							break;
						default:
							e.es.filter(), e.highlight(0);
					}
				});
			}),
			(EditableSelectUtility.prototype.highlight = function(t) {
				var e = this;
				e.es.show(),
					setTimeout(function() {
						var i = e.es.$list.find("li.es-visible"),
							s = e.es.$list.find("li.selected").removeClass("selected"),
							l = i.index(s);
						if (i.length > 0) {
							var o = (i.length + t) % i.length,
								n = i.eq(o),
								a = n.position().top;
							n.addClass("selected"),
								o < l &&
								a < 0 &&
								e.es.$list.scrollTop(e.es.$list.scrollTop() + a),
								o > l &&
								a + n.outerHeight() > e.es.$list.outerHeight() &&
								e.es.$list.scrollTop(
									e.es.$list.scrollTop() +
									n.outerHeight() +
									2 * (a - e.es.$list.outerHeight())
								);
						}
					});
			}),
			(EditableSelectUtility.prototype.setAttributes = function(e, i, s) {
				t.each(i || {}, function(t, i) {
					e.attr(i.name, i.value);
				}),
					e.data(s);
			}),
			(EditableSelectUtility.prototype.trigger = function(t) {
				var e = Array.prototype.slice.call(arguments, 1),
					i = [t + ".editable-select"];
				i.push(e),
					this.es.$select.trigger.apply(this.es.$select, i),
					this.es.$input.trigger.apply(this.es.$input, i);
			}),
			(Plugin = function(e) {
				var i = Array.prototype.slice.call(arguments, 1);
				return this.each(function() {
					var s = t(this),
						l = s.data("editable-select"),
						o = t.extend(
							{},
							EditableSelect.DEFAULTS,
							s.data(),
							"object" == typeof e && e
						);
					l || (l = new EditableSelect(this, o)),
						"string" == typeof e && l[e].apply(l, i);
				});
			}),
			(t.fn.editableSelect = Plugin),
			(t.fn.editableSelect.Constructor = EditableSelect);
	})(jQuery);

	$("#region").editableSelect({
		effects: "slide",
		duration: 200,
		appendTo: "body",
	});
	$("#country").editableSelect({
		effects: "slide",
		duration: 200,
		appendTo: "body",
	});
	$("#city").editableSelect({
		effects: "slide",
		duration: 200,
		appendTo: "body",
	});
	// 맨 처음 한번만 가져옴
	$.get("/tour/regions", {}, function(regionsResult) {
		// 대륙 수
		var regionsCnt = regionsResult.regionsCount;

		for (var i = 0; i < regionsCnt; i++) {
			$("#region").editableSelect('add', function() {
				$(this).attr('value', regionsResult.regions[i].regionId);
				$(this).text(regionsResult.regions[i].regionName);
			});
		}
	});
	$("#region").editableSelect().on("select.editable-select", function(e, li) {
		$("#country").editableSelect('clear');
		$("#city").editableSelect('clear');
		$("#country").removeAttr("disabled");
		var regionId = li.val();

		setTimeout(function() {
			$.get(`/tour/countries/${regionId}`, {}, function(countriesResilt) {
				// 대륙 별 국가 수
				var countriesCnt = countriesResilt.countriesCount;

				for (var i = 0; i < countriesCnt; i++) {
					$("#country").editableSelect('add', function() {
						$(this).attr('value', countriesResilt.countries[i].countryId);
						$(this).text(countriesResilt.countries[i].countryName);
					});
				}

			});
		}, 200);

	});

	$("#country").editableSelect().on("select.editable-select", function(e, li) {
		$("#city").editableSelect('clear');
		$("#city").removeAttr("disabled");
		var countryId = li.val();

		setTimeout(function() {
			$.get(`/tour/cities/${countryId}`, {}, function(citiesResult) {

				// 국가 별 도시 수
				var citiesCnt = citiesResult.citiesCount;

				for (i = 0; i < citiesCnt; i++) {
					$("#city").editableSelect('add', function() {
						$(this).attr('value', citiesResult.cities[i].cityId);
						$(this).text(citiesResult.cities[i].cityName);
					});
				}
			});
		}, 200);

	});
	// 도시 아이디를 계속 못가져오길래 어떻게 할까 생각하다가 그냥 hidden 하나 만들어서 거기에
	// value로 할당함
	$("#city").editableSelect().on("select.editable-select", function(e, li) {
		var cityId = li.val();
		$("#hidden-ipt").attr('value', cityId)
	});
	
});
