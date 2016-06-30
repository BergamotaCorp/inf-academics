var gulp = require('gulp');
var concat = require('gulp-concat');
var sass = require('gulp-sass');
var coffee = require('gulp-coffee');

var paths = {
    components: ['./bower_components'],
    coffee: ['./src/main/coffee'],
    sass : ['./src/main/scss'],
    dist : ['./src/main/resources/static']
};

gulp.task('sass', function () {
  gulp.src(`${paths.sass}/main.scss`)
    .pipe(sass({outputStyle: 'expanded'})
      .on('error', sass.logError))
    .pipe(concat('app.css'))
    .pipe(gulp.dest(`${paths.dist}/css/`))
      .on('finish', console.log);
});

gulp.task('coffee', function () {
    gulp.src(`${paths.coffee}/**/*.coffee`)
      .pipe(coffee({ bare: true }))
      .pipe(concat('app.js'))
      .pipe(gulp.dest(`${paths.dist}/js/`))
      .on('finish', console.log);
});

gulp.task("components", function () {
    gulp.src([
        `${paths.components}/jquery/dist/jquery.min.js`,
        `${paths.components}/tether/dist/js/tether.min.js`,
        `${paths.components}/bootstrap/dist/js/bootstrap.min.js`,
        `${paths.components}/magicsuggest/magicsuggest-min.js`
    ])
    .pipe(concat('components.js'))
    .pipe(gulp.dest(`${paths.dist}/js/`))
    .on('finish', console.log);

    gulp.src([
        `${paths.components}/tether/dist/css/tether.min.css`,
        `${paths.components}/magicsuggest/magicsuggest-min.css`
    ])
    .pipe(concat('components.css'))
        .pipe(gulp.dest(`${paths.dist}/css/`))
    .on('finish', console.log);

});

gulp.task('install', ['sass', 'coffee','components'], function(callback){
 console.log("Install complete");
});

gulp.task('watch', function() {
  gulp.watch([`${paths.sass}/**/*.scss`, `${paths.coffee}/**/*.coffee`], ['sass','coffee']).on('error',console.log);
});
